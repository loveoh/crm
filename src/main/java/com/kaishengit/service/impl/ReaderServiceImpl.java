package com.kaishengit.service.impl;

import com.kaishengit.mapper.ReaderMapper;
import com.kaishengit.pojo.Reader;
import com.kaishengit.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    /**
     * 判断如果看过公告的人就不再重复存储了
     * @param reader
     */
    @Override
    public void save(Reader reader) {

        List<Reader> readerList = readerMapper.findReaderById(reader.getUserid());

        if (readerList.isEmpty()){
            readerMapper.save(reader);
        }
    }

    @Override
    public List<Reader> findByNoticeId(Integer id) {
        return readerMapper.findByNoticeId(id);
    }
}
