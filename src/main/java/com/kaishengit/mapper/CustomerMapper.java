package com.kaishengit.mapper;

import com.kaishengit.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/15.
 */
public interface CustomerMapper {


    void save(Customer customer);


    List<Customer> findBySearch(@Param("start") Integer start,
                                @Param("length") Integer length,
                                @Param("search") String search);

    Integer findBySearchCount(@Param("search") String search);

    List<Customer> findCompanyAll();

    Customer findCompanyById(Integer companyid);

    Customer findById(Integer id);

    void update(Customer customer);
}
