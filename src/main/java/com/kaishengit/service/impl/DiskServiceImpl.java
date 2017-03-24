package com.kaishengit.service.impl;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.mapper.DiskMapper;
import com.kaishengit.pojo.Disk;
import com.kaishengit.service.DiskService;
import com.kaishengit.shiro.ShiroUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by 刘忠伟 on 2017/3/23.
 */
@Service
public class DiskServiceImpl implements DiskService {

    @Autowired
    private DiskMapper diskMapper;

    @Value("${filePath}")
    private String filePath;


    /**
     * 根据fid查找此fid下的全部
     * @param fid
     * @return
     */
    @Override
    public List<Disk> findByFid(Integer fid) {
        return diskMapper.findByFid(fid);
    }



    /**
     * 文件上传
     * @param file
     */
    @Override
    @Transactional
    public Disk uploader(MultipartFile file,Integer fid) {
        String fileSourceName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();
        if(fileSourceName.lastIndexOf(".") != -1){//有后缀时
            fileName = fileName + fileSourceName.substring(fileSourceName.lastIndexOf("."));
        }

        try {
            InputStream inputStream = file.getInputStream();

            FileOutputStream outputStream = new FileOutputStream(new File(filePath, fileName));

            IOUtils.copy(inputStream,outputStream);

            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new ServiceException("文件上传失败！");
        }

        //保存到数据库
        Disk disk = new Disk();
        disk.setFid(fid);
        disk.setSize(FileUtils.byteCountToDisplaySize(file.getSize()));
        disk.setSourceName(fileSourceName);
        disk.setType(Disk.TYPE_FILE);
        disk.setNewName(fileName);
        disk.setCreateTime(new DateTime().toString("yyyy-MM-dd hh:mm:ss"));
        disk.setCreateUser(ShiroUtil.getCurrentUserName());

        diskMapper.save(disk);

        return disk;
    }

    @Override
    public Disk findById(Integer id) {

        Disk disk = diskMapper.findById(id);
        if(disk != null){
            return disk;
        } else {
             throw new NotFoundException();
        }
    }

    /**
     * 文件下载
     * @param id
     * @param response
     */
    @Override
    public void download(Integer id, HttpServletResponse response) throws UnsupportedEncodingException {
        Disk disk = diskMapper.findById(id);

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename='"+ new String(disk.getSourceName().getBytes("UTF-8"),"ISO8859-1") +"'");

        try {
            OutputStream outputStream = response.getOutputStream();
            FileInputStream inputStream = new FileInputStream(new File(filePath,disk.getNewName()));
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            throw new ServiceException("文件下载失败！");
        }
    }

    /**
     * 创建文件夹
     * 文件夹是虚拟的
     * @param disk
     */
    @Override
    public void saveDir(Disk disk) {

        disk.setCreateUser(ShiroUtil.getCurrentUserName());
        disk.setCreateTime(new DateTime().toString("yyyy-MM-dd hh:mm:ss"));
        disk.setType(Disk.TYPE_FOLDER);

        diskMapper.save(disk);

    }
}
