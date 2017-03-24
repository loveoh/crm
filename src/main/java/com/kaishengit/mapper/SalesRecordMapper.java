package com.kaishengit.mapper;

import com.kaishengit.pojo.SalesRecord;

import java.util.List;

/**
 * Created by loveoh on 2017/3/22.
 */
public interface SalesRecordMapper {
    void save(SalesRecord salesRecord);

    List<SalesRecord> findBySalesId(Integer id);
}
