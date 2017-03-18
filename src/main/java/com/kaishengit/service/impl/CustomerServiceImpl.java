package com.kaishengit.service.impl;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.service.CustomerService;
import com.kaishengit.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/15.
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询Customer客户信息
     * @param start  起始行
     * @param length  查多少个
     * @param search  查询关键字，根据手机号或者name，like查询
     * @return
     */
    @Override
    public List<Customer> getCustomer(Integer start, Integer length, String search) {

        return customerMapper.findBySearch(start,length,search);

    }

    /**
     * 查询Customer客户信息   的总数量
     * @param search
     * @return
     */
    @Override
    public Integer getCustomerCount(String search) {
        return customerMapper.findBySearchCount(search);
    }

    /**
     * 获取所有的公司
     * @return
     */
    @Override
    public List<Customer> findCompany() {
        return customerMapper.findCompanyAll();

    }

    /**
     * 新增用户
     * @param customer
     */
    @Override
    public void save(Customer customer) {

        if("customer".equals(customer.getType()) && customer.getCompanyid()!= null) {//个人+公司

            Customer customer1 = customerMapper.findCompanyById(customer.getCompanyid());
            if (customer1 != null) {
                customer.setCompanyname(customer1.getCompanyname());
            } else {
                throw new NotFoundException();
            }
        }

        customer.setUserid(ShiroUtil.getCurrentUserId());

        customerMapper.save(customer);

    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Override
    public Customer findById(Integer id) {
        return customerMapper.findById(id);
    }

    /**
     * 修改 ，创建时间不能修改，公司名字不能直接改变，需要根据companyid找到公司名字，在赋给customer
     * @param customer
     */
    @Override
    public void eidtCustomer(Customer customer) {

        //是公司，无companyid，并且直接修改公司名字

        if("customer".equals(customer.getType())&&customer.getCompanyid()!= null){
            //个人-公司，有companyid，companyname,并且根据companyid查到companyname,修改的是个人名字
            Customer customer2 = customerMapper.findCompanyById(customer.getCompanyid());
            if (customer2 != null) {
                customer.setCompanyname(customer2.getCompanyname());
            } else {
                throw new NotFoundException();
            }

        }
        //个人，  无companyid，companyname，修改的是个人name

        customerMapper.update(customer);


    }

    /**
     * 删除，  公司的话删除全部关联的
     * @param id
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        Customer customer = customerMapper.findById(id);

        if(customer != null){
            //1删除客户或者公司
            customerMapper.deleteById(id);

            if("company".equals(customer.getType())){
                //2删除公司的关联
                customerMapper.deleteByCompanyId(customer.getId());
            }
        } else {
            throw new NotFoundException();
        }


    }


}
