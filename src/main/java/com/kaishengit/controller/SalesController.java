package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.Sales;
import com.kaishengit.pojo.SalesRecord;
import com.kaishengit.pojo.User;
import com.kaishengit.service.CustomerService;
import com.kaishengit.service.SalesRecordService;
import com.kaishengit.service.SalesService;
import com.kaishengit.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by loveoh on 2017/3/22.
 */
@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SalesRecordService salesRecordService;

    @GetMapping
    public String salesList(Model model){
        User user = ShiroUtil.getCurrentUser();
        List<Customer> customerList = customerService.findCustomerByUserId(user.getId());
        model.addAttribute("customerList",customerList);
        return "sales/list";
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<Sales> load(HttpServletRequest request) throws UnsupportedEncodingException {
        String draw = request.getParameter("draw");
        String start  = request.getParameter("start");
        String length = request.getParameter("length");
        String name = request.getParameter("name");
        name = new String(name.getBytes("Iso8859-1"),"utf-8");
        String progress = request.getParameter("progress");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");


        Map<String,String> queryParam = Maps.newHashMap();
        queryParam.put("start",start);
        queryParam.put("length",length);
        queryParam.put("name", name);
        queryParam.put("progress",progress);
        queryParam.put("startTime",startTime);
        queryParam.put("endTime",endTime);

        Long count = salesService.count();
        List<Sales> salesList = salesService.findSalesByQueryParam(queryParam);

        return new DataTablesResult<>(draw,salesList,count,count);

    }

    /**
     * 新增销售机会
     * @param sales
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public String newSales(Sales sales){

       salesService.save(sales);
        return "success";
    }

    /**
     * 查询销售机会详情表
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String viewDetail (@PathVariable Integer id, Model model){
        Sales sales = salesService.findSalesById(id);
        List<SalesRecord> salesLogList = salesRecordService.findBySalesId(id);

        model.addAttribute("sales",sales);
        model.addAttribute("salesLogList",salesLogList);

        return "sales/view";
    }

    /**
     * 删除销售机会
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id:\\d+}", method = RequestMethod.GET)
    public String delSales (@PathVariable Integer id){
        Sales sales = salesService.findSalesById(id);
        if (sales != null){
            salesService.deleteSalesBySalesId(id);
            return "redirect:/sales";
        }else{
            throw new NotFoundException();
        }


    }

    /**
     * 修改当前进度
     * @param request
     * @return
     */
    @RequestMapping(value = "/progress/edit",method = RequestMethod.POST)
    @Transactional
    public String progressEdit(HttpServletRequest request){
        String id = request.getParameter("id");
        String progress = request.getParameter("progress");
        salesService.editProgress(id,progress);

        return "redirect:/sales/"+id;
    }

    /**
     * 添加新进的跟进记录
     * @return
     */
    @RequestMapping(value = "log/new",method = RequestMethod.POST)
    public String newLog(SalesRecord salesRecord){

        salesRecordService.saveNewSalesRecord(salesRecord);
        return "redirect:/sales" +salesRecord.getSalesid();
    }
}
