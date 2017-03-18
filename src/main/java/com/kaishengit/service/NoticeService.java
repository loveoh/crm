package com.kaishengit.service;

import com.kaishengit.pojo.Notice;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
public interface NoticeService {
    List<Notice> findNoticeByQueryParam(String start, String length);

    Long count();

}
