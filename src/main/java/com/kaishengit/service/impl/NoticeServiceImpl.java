package com.kaishengit.service.impl;

import com.kaishengit.mapper.NoticeMapper;
import com.kaishengit.pojo.Notice;
import com.kaishengit.service.NoticeService;
import com.kaishengit.shiro.ShiroUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by loveoh on 2017/3/18.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Value("${imagePath}")
    private String savePath;
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> findNoticeByQueryParam(String start, String length) {
        return noticeMapper.findByQueryParam(start,length);
    }

    @Override
    public Long count() {
        return noticeMapper.count();
    }

    @Override
    public Notice findNoticeByNoticeId(Integer id) {
        return noticeMapper.findByNoticeId(id);
    }

    /**
     * 文件上传
     * @param inputStream
     * @param originalFilename
     * @return
     */
    @Override
    public String saveImage(InputStream inputStream, String originalFilename) throws IOException {
        String sufName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + sufName;

        //获取输出流,需要知道输出的文件路径和文件名
        OutputStream outputStream = new FileOutputStream(new File(savePath,newName));
        IOUtils.copy(inputStream,outputStream);
        outputStream.flush();
        outputStream.close();
        inputStream.close();

        return "/preview/"+ newName;
    }

    /**
     * 保存公告内容
     * @param notice
     */
    @Override
    public void save(Notice notice) {
        notice.setRealname(ShiroUtil.getCurrentUserName());
        notice.setUserid(ShiroUtil.getCurrentUserId());

        noticeMapper.save(notice);
    }
}
