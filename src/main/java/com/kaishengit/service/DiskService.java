package com.kaishengit.service;

import com.kaishengit.pojo.Disk;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/23.
 */
public interface DiskService {
    List<Disk> findByFid(Integer fid);

    Disk uploader(MultipartFile file,Integer fid);

    Disk findById(Integer id);

    void download(Integer id, HttpServletResponse response) throws UnsupportedEncodingException;

    void saveDir(Disk disk);
}
