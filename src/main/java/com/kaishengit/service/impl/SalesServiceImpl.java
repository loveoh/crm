package com.kaishengit.service.impl;

import com.kaishengit.mapper.SalesMapper;
import com.kaishengit.pojo.Sales;
import com.kaishengit.pojo.SalesRecord;
import com.kaishengit.service.CustomerService;
import com.kaishengit.service.SalesRecordService;
import com.kaishengit.service.SalesService;
import com.kaishengit.shiro.ShiroUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by loveoh on 2017/3/22.
 */
@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SalesRecordService salesRecordService;
    @Autowired
    private SalesService salesService;

    @Override
    public Long count() {
        return salesMapper.count();
    }

    @Override
    public List<Sales> findSalesByQueryParam(Map<String, String> queryParam) {
        return salesMapper.findByQueryParam(queryParam);
    }

    /**
     * 新增销售机会
     * @param sales
     */
    @Override
    @Transactional
    public void save(Sales sales) {
        //封装sales的其他属性
        sales.setUsername(ShiroUtil.getCurrentRealName());
        sales.setUserid(ShiroUtil.getCurrentUserId());
        sales.setCustname(customerService.findById(sales.getCustmoerid()).getName());

        salesMapper.save(sales);

        //添加销售机会的同时 需要记录添加记录,下个页面需要查询销售记录
        SalesRecord salesRecord = new SalesRecord();
        salesRecord.setType(SalesRecord.TYPE_AUTO);//自动创建销售机会记录
        salesRecord.setContent(ShiroUtil.getCurrentRealName()+"创建了该销售机会");
        salesRecord.setSalesid(sales.getId());

        salesRecordService.save(salesRecord);

    }

    @Override
    public Sales findSalesById(Integer id) {
        return salesMapper.findById(id);
    }

    @Override
    public void deleteSalesBySalesId(Integer salesid) {
        salesMapper.deleteBySalesId(salesid);
    }

    @Override
    @Transactional
    public void editProgress(String id, String progress) {

        Sales sales = salesService.findSalesById(Integer.parseInt(id));
        sales.setProgress(progress);

        //修改跟进时间
        sales.setLasttime(DateTime.now().toString("yyyy-MM-dd"));
        //判断是否完成订单,完成之后还要修改订单完成时间
        if ("完成交易".equals(progress)){
            sales.setSuccesstime(DateTime.now().toString("yyyy-MM-dd"));
        }
        salesMapper.update(sales);

        //修改当前进度需要写入进度数据库(插入一条新数据)
        SalesRecord salesRecord = new SalesRecord();
        salesRecord.setSalesid(Integer.parseInt(id));
        salesRecord.setType(SalesRecord.TYPE_AUTO);
        salesRecord.setContent(ShiroUtil.getCurrentRealName()+"更改进度为:"+progress);
        salesRecordService.save(salesRecord);

    }


}
