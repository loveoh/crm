package com.kaishengit.service;

import com.kaishengit.pojo.SalesRecord;

import java.util.List;

/**
 * Created by loveoh on 2017/3/22.
 */
public interface SalesRecordService {
    void save(SalesRecord salesRecord);

    List<SalesRecord> findBySalesId(Integer id);

    void saveNewSalesRecord(SalesRecord salesRecord);

}
