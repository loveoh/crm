package com.kaishengit.controller;

import com.kaishengit.dto.AjaxResult;

import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Customer;
import com.kaishengit.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/15.
 */
@Controller
@RequestMapping("/customerManagement")
public class CustomerManagementController {


    @Autowired
    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(CustomerManagementController.class);



    /**
     *  跳转到用户管理界面
     * @return
     */
    @GetMapping
    public String getCustomer(){

        return "customer/list";
    }


    /**
     *  datatables的ajax请求，
     * @return  客户数据
     */
    @PostMapping("/data.json")
    @ResponseBody
    public DataTablesResult custListData(String draw, Integer start, Integer length,
                                         @RequestParam(name = "search[value]") String search){

        Long tatol = Long.valueOf(customerService.getCustomerCount(search));

        List<Customer> customerList = customerService.getCustomer(start,length,search);

        DataTablesResult result = new DataTablesResult();

        result.setDraw(draw);
        result.setRecordsTotal(tatol);
        result.setRecordsFiltered(tatol);
        result.setData(customerList);

        return result;
    }


    /**
     *  获取所有的公司
     * @return
     */
    @GetMapping("/company")
    @ResponseBody
    public AjaxResult getCompanyAll(){
        List<Customer> customerList = customerService.findCompany();
        return new AjaxResult(customerList);
    }


    /**
     * 新增客户
     * @return
     */
    @PostMapping("/newCustmoer")
    @ResponseBody
    public AjaxResult saveCustmoer(Customer customer){

        try {
            customerService.save(customer);
            return new AjaxResult(customer);
        } catch (NotFoundException ex){
            ex.printStackTrace();
            logger.error("添加新用户失败！");
            return new AjaxResult("添加新用户失败！");
        }
    }


    /**
     * 根据id查找
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}/customer")
    @ResponseBody
    public AjaxResult Customer(@PathVariable Integer id){

        Customer customer = customerService.findById(id);

        return new AjaxResult(customer);
    }


    /**
     * 修改customer
     * @return
     */
    @PostMapping("/eidt")
    @ResponseBody
    public AjaxResult eidt(Customer customer){
        try {
            customerService.eidtCustomer(customer);
            return new AjaxResult(AjaxResult.SUCCESS,"修改成功！");
        } catch (NotFoundException ex){
            ex.printStackTrace();
            logger.error("修改失败！");
            return new AjaxResult("修改失败！");
        }
    }




}
