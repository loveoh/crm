package com.kaishengit.mapper;

import com.kaishengit.pojo.Notice;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
public interface NoticeMapper {

    List<Notice> findByQueryParam(String start, String length);

    Long count();

    Notice findByNoticeId(Integer id);

    void save(Notice notice);
}
