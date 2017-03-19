package com.kaishengit.service;

import com.kaishengit.pojo.Reader;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
public interface ReaderService {
    void save(Reader reader);

    List<Reader> findByNoticeId(Integer id);
}
