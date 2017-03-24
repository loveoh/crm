package com.kaishengit.service;

import com.kaishengit.pojo.Sales;

import java.util.List;
import java.util.Map;

/**
 * Created by loveoh on 2017/3/22.
 */
public interface SalesService {
    Long count();

    List<Sales> findSalesByQueryParam(Map<String, String> queryParam);


    void save(Sales sales);

    Sales findSalesById(Integer id);

    void deleteSalesBySalesId(Integer salesid);



    void editProgress(String id, String progress);
}
