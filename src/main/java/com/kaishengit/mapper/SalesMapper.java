package com.kaishengit.mapper;

import com.kaishengit.pojo.Sales;

import java.util.List;
import java.util.Map;

/**
 * Created by loveoh on 2017/3/22.
 */
public interface SalesMapper {
    Long count();

    List<Sales> findByQueryParam(Map<String, String> queryParam);

    void save(Sales sales);

    Sales findById(Integer id);

    void deleteBySalesId(Integer salesid);

    void update(Sales sales);

    void updateLastTime(Sales sales);
}
