package com.kaishengit.service;

import com.kaishengit.pojo.Customer;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/15.
 */
public interface CustomerService {

    List<Customer> getCustomer(Integer start, Integer length, String search);

    Integer getCustomerCount(String search);

    List<Customer> findCompany();

    void save(Customer customer);

    Customer findById(Integer id);

    void eidtCustomer(Customer customer);

    void delete(Integer id);
}
