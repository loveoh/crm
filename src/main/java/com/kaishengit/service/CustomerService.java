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

<<<<<<< HEAD


    List<Customer> findCustomerByUserId(Integer id);
=======
    void delete(Integer id);

    Customer findCustomer(Integer id);

    List<Customer> findByCompanyId(Integer id);

    void openCust(Integer id);


    String makeMeCard(Integer id);

    List<User> findUserAll();

    void moveCust(Integer id, Integer userid);
>>>>>>> 2f30d3f42a4598c0e53125d7cfb8c6b09accb127
}
