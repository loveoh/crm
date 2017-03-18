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
                                @Param("search") String search,
                                @Param("userid") Integer userid);

    Integer findBySearchCount(@Param("search") String search, @Param("userid") Integer userid);

    List<Customer> findCompanyAll(Integer userid);

    Customer findCompanyById(@Param("companyid") Integer companyid,@Param("userid")Integer userid);

    Customer findById(@Param("id") Integer id, @Param("userid") Integer userid);

    void update(Customer customer);

    void deleteById(Integer id);

    void deleteByCompanyId(Integer companyid);

    Customer findCustomer(@Param("id") Integer id, @Param("userid") Integer userid);

    List<Customer> findCustomerByCompanyId(@Param("id") Integer id, @Param("userid") Integer userid);
}
