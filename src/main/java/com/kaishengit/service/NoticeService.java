package com.kaishengit.service;

import com.kaishengit.pojo.Notice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
public interface NoticeService {
    List<Notice> findNoticeByQueryParam(String start, String length);

    Long count();

    Notice findNoticeByNoticeId(Integer id);

    String saveImage(InputStream inputStream, String originalFilename) throws IOException;

    void save(Notice notice);
}
