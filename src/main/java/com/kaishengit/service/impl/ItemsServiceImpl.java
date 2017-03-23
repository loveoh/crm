package com.kaishengit.service.impl;

import com.kaishengit.dto.Task;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.ItemsMapper;
import com.kaishengit.pojo.Items;
import com.kaishengit.service.ItemsService;
import com.kaishengit.shiro.ShiroUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/19.
 */
@Service
public class ItemsServiceImpl implements ItemsService {


    @Autowired
    private ItemsMapper itemsMapper;

    /**
     * 新增客户通知
     * @param items
     * @param hour
     * @param min
     */
    @Override
    public void save(Items items, String hour, String min) {
        items.setUserid(ShiroUtil.getCurrentUserId());
        items.setCreateUser(ShiroUtil.getCurrentUserName());
        items.setDone(Items.UNDONE);
        items.setRemindTime(items.getStartTime()+" "+hour+":"+min);

        itemsMapper.save(items);

    }

    /**
     * 查询全部延期事项（new date>end_time,并且未完成的）
     * @return
     */
    @Override
    public List<Items> findAllPutOff() {
        String date = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        return itemsMapper.findPutOff(date,ShiroUtil.getCurrentUserId());
    }

    /**
     * 查询全部 要在容器插件中显示的事项
     *         -- 已完成的
     *         -- new date<end_time,且未完成
     *
     * @return
     */
    @Override
    public List<Items> findAllDate() {
        List<Items> itemsList = itemsMapper.findAllDate(new DateTime().toString("YYYY-MM-DD HH:mm"),ShiroUtil.getCurrentUserId());
        itemsList.addAll(itemsMapper.findAllDone(ShiroUtil.getCurrentUserId()));

        return itemsList;
    }

    /**
     * 根据id删除待办事项
     * @param id
     */
    @Override
    public void delete(Integer id) {

        Items items = itemsMapper.findById(id);

        if(items != null){
            itemsMapper.delete(id);
        } else {
            throw new NotFoundException();
        }

    }

    /**
     * 日历每页显示
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<Task> findTaskByUserId(String start, String end) {
        List<Items> itemsList = itemsMapper.findTaskByUserId(start,end,ShiroUtil.getCurrentUserId());

        List<Task> taskList = new ArrayList<>();
        for(Items items:itemsList){
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
            taskList.add(task);
        }
        return taskList;
    }

    /**
     * 标记已完成
     * @param id
     */
    @Override
    public void doneById(Integer id) {
        Items items = itemsMapper.findById(id);
        if(items != null){
            itemsMapper.done(id);

        } else {
            throw new NotFoundException();
        }
    }


}
