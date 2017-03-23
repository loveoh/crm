package com.kaishengit.service;

import com.kaishengit.dto.Task;
import com.kaishengit.pojo.Items;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/19.
 */
public interface ItemsService {
    void save(Items items, String hour, String min);

    List<Items> findAllPutOff();

    List<Items> findAllDate();

    void delete(Integer id);


    List<Task> findTaskByUserId(String start, String end);

    void doneById(Integer id);
}
