package com.kaishengit.service;

import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.User;

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

    Customer findCustomer(Integer id);

    List<Customer> findByCompanyId(Integer id);

    void openCust(Integer id);


    String makeMeCard(Integer id);
}
