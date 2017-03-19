package com.kaishengit.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.kaishengit.dto.AjaxResult;

import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.User;
import com.kaishengit.service.CustomerService;

import com.kaishengit.shiro.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 删除 ，     公司的话和删除所有关联的
     * @param id
     * @return
     */
    @GetMapping("/del/{id:\\d+}")
    @ResponseBody
    public AjaxResult del(@PathVariable Integer id){

        if(ShiroUtil.isManager()){
            customerService.delete(id);
        } else {
            return new AjaxResult("您没有权限不能删除");
        }


        return new AjaxResult(AjaxResult.SUCCESS,"删除成功！");
    }


    /**
     * 根据id查找，并且展示
     */
    @GetMapping("{id:\\d+}")
    public String show(@PathVariable Integer id, Model model){

        Customer customer = customerService.findCustomer(id);

        //如果是公司，则返回所有关联用户
        if("company".equals(customer.getType())){
            model.addAttribute("customerList",customerService.findByCompanyId(id));
        }


        List<User> userList = customerService.findUserAll();

        System.out.println(customer.getItemsList().size());
        model.addAttribute("customer",customer);
        model.addAttribute("userList",userList);
        return "customer/show";
    }


    /**
     * 公开客户，需要userid字段为空
     */
    @PostMapping("/{id:\\d+}/openCust")
    @ResponseBody
    public AjaxResult openCust(@PathVariable Integer id){

        try {
            customerService.openCust(id);
            return new AjaxResult(AjaxResult.SUCCESS,"客户公开成功！");
        } catch (NotFoundException ex) {
            ex.printStackTrace();
            logger.error("找不到id为{}的custmoer",id);
            return new AjaxResult("客户公开失败！");
        }
    }


    /**
     * 返回二维码
     */
    @GetMapping("/qrcode/{id:\\d+}.png")
    @ResponseBody
    public void testEncode(@PathVariable Integer id, HttpServletResponse response) throws WriterException, IOException {

        String mecard =customerService.makeMeCard(id);

        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
        Map<EncodeHintType,String> hints=new HashMap<EncodeHintType,String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix= null;

        bitMatrix = multiFormatWriter.encode(mecard, BarcodeFormat.QR_CODE, 200, 200, hints);
        OutputStream outputStream = response.getOutputStream();


        //放入输出流或者响应输出流


        MatrixToImageWriter.writeToStream(bitMatrix, "jpg", outputStream);


        outputStream.flush();
        outputStream.close();
    }


    /**
     * 转移客户，是公司需要转译关联客户。
     * @return
     */
    @GetMapping("/moveCust")
    @ResponseBody
    public AjaxResult moveCust(Integer id,Integer userid){
        try {
            customerService.moveCust(id, userid);
            return  new AjaxResult(AjaxResult.SUCCESS,"转移客户成功！");
        } catch (NotFoundException ex) {
            ex.printStackTrace();
            logger.error("转移客户错误");
            return new AjaxResult("转移客户失败！");
        }
    }

}
