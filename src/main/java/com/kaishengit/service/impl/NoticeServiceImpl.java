package com.kaishengit.service.impl;

import com.kaishengit.mapper.NoticeMapper;
import com.kaishengit.pojo.Notice;
import com.kaishengit.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

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
}
