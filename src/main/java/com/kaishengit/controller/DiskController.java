package com.kaishengit.controller;


import com.kaishengit.exception.ServiceException;
import com.kaishengit.pojo.Disk;
import com.kaishengit.service.DiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.util.List;


/**
 * Created by 刘忠伟 on 2017/3/23.
 */
@Controller
@RequestMapping("/doc")
public class DiskController {

    @Autowired
    private DiskService diskService;



    private Logger logger = LoggerFactory.getLogger(DiskController.class);

    /**
     * 显示文件，根据fid查，就是查fid文件夹下的所有文件。0为第一级文件夹。
     * @param fid
     * @return
     */
    @GetMapping()
    public String getDisk(@RequestParam(name = "fid",required = false,defaultValue = "0") Integer fid, Model model){

        List<Disk> diskList = diskService.findByFid(fid);
        model.addAttribute("diskList",diskList);
        /*如果在当前级别的文件夹下上传文件，需要使用fid，所以再传到页面*/
        model.addAttribute("fid",fid);//当第一级文件夹下是0
        return "disk/list";
    }


    /**
     * 文件上传
     * @return
     */
    @PostMapping("/uploader")
    @ResponseBody
    public Disk uploader(MultipartFile file,Integer fid){/*webuploader的表单name值必须file*/

        try {
            Disk disk = diskService.uploader(file, fid);
            return disk;
        }catch (ServiceException ex){
            ex.printStackTrace();
            logger.error("文件上传失败！");
            return null;
        }
    }

    /**
     * 文件下载
     */
    @GetMapping("/{id:\\d+}/download")
    public void download(@PathVariable Integer id, HttpServletResponse response){

        try {
            diskService.download(id, response);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }

    }

    /**
     * 创建文件夹
     * @return
     */
    @PostMapping("/dir/new")
    public String saveDir(Disk disk){

        diskService.saveDir(disk);

        return "redirect:/doc?fid="+disk.getFid();
    }


}
