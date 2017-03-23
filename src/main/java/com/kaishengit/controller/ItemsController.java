package com.kaishengit.controller;

import com.kaishengit.dto.AjaxResult;
import com.kaishengit.dto.Task;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Items;
import com.kaishengit.service.ItemsService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/19.
 *  待办事项分为--》针对员工的待办
 *              --》针对客户的待办
 *              --》针对销售机会的待办
 *
 */

@Controller
@RequestMapping("/task")
public class ItemsController {



    private Logger logger = LoggerFactory.getLogger(ItemsController.class);

    @Autowired
    private ItemsService itemsService;
    /**
     * 针对客户的待办
     * @return
     */
    @PostMapping("/new")
    @ResponseBody
    public AjaxResult newCustomerTask(Items items,String hour,String min){


        itemsService.save(items,hour,min);
        Task task = new Task();
        task.setId(items.getId());
        task.setUserid(items.getUserid());
        task.setSalesid(items.getSalesid());
        task.setColor(items.getColor());
        task.setCustid(items.getCustomerid());
        task.setDone(items.getDone());
        task.setEnd(items.getEndTime());
        task.setRemindertime(items.getRemindTime());
        task.setStart(items.getStartTime());
        task.setTitle(items.getTitle());
        return new AjaxResult(task);

    }

    /**
     * 跳转到待办页面，
     * 并且需要传值
     *          --已延期事项（超过end_time，且状态为 未完成）
     *          --日历显示的事项（已完成+待办（new date < end_time,未完成））
     * @return
     */
    @GetMapping()
    public String getTask(Model model){

        //延期事项
        List<Items> putOffList = itemsService.findAllPutOff();

        model.addAttribute("putOffList",putOffList);

        return "task/list";
    }

    /*日历发送的请求*/

    /**
     * 每个日历页面的数据
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public List<Task> load(String start,String end) {
        List<Task> taskList = itemsService.findTaskByUserId(start,end);
        return taskList;
    }


    /**
     * 根据 id删除待办事项
     * @return
     */
    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public AjaxResult delete(@PathVariable Integer id){

        try {
            itemsService.delete(id);
            return new AjaxResult(AjaxResult.SUCCESS,"删除成功！");
        } catch (NotFoundException ex){
            logger.error("找不到待办事项");
            return new AjaxResult("删除失败！此数据不存在或者已经被删除。");
        }

    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @GetMapping("/delBatch")
    @ResponseBody
    public AjaxResult deleteBatch( String ids){


        String[] strings = ids.split(",");


        try {
            for (int i = 0;i<strings.length;i++) {
                if(i != strings.length-1){
                    itemsService.delete(Integer.parseInt(String.valueOf(strings[i])));

                }
            }
            return new AjaxResult(AjaxResult.SUCCESS,"删除成功！");
        } catch (NotFoundException ex){
            logger.error("找不到待办事项");
            return new AjaxResult("删除失败！此数据不存在或者已经被删除。");
        }

    }

    @PostMapping("/{id:\\d+}/done")
    @ResponseBody
    public AjaxResult done(@PathVariable Integer id){

        itemsService.doneById(id);

        return new AjaxResult(AjaxResult.SUCCESS,"已经标记成已完成！");
    }


}
