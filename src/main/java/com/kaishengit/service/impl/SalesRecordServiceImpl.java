package com.kaishengit.service.impl;

import com.kaishengit.mapper.SalesMapper;
import com.kaishengit.mapper.SalesRecordMapper;
import com.kaishengit.pojo.Sales;
import com.kaishengit.pojo.SalesRecord;
import com.kaishengit.service.SalesRecordService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by loveoh on 2017/3/22.
 */
@Service
public class SalesRecordServiceImpl implements SalesRecordService {

    @Autowired
    private SalesRecordMapper salesRecordMapper;
    @Autowired
    private SalesMapper salesMapper;

    @Override
    public void save(SalesRecord salesRecord) {
        salesRecordMapper.save(salesRecord);
    }

    /**
     * 根据salesid查询销售记录
     * @param id
     * @return
     */
    @Override
    public List<SalesRecord> findBySalesId(Integer id) {

        return salesRecordMapper.findBySalesId(id);
    }

    /**
     * 存储新进记录
     * @param salesRecord
     */
    @Override
    @Transactional
    public void saveNewSalesRecord(SalesRecord salesRecord) {
        salesRecord.setType(SalesRecord.TYPE_INPUT);
        salesRecordMapper.save(salesRecord);

        //需要修改最后跟进时间
        Sales sales = salesMapper.findById(salesRecord.getSalesid());
        sales.setLasttime(DateTime.now().toString("yyyy-MM-dd"));
        salesMapper.updateLastTime(sales);
    }
}
