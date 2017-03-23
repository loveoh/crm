package com.kaishengit.mapper;

import com.kaishengit.pojo.Items;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/19.
 */
public interface ItemsMapper {


    void save(Items items);


    List<Items> findByCustAndUser(@Param("custId") Integer custId,@Param("userId") Integer userId);

    List<Items> findByUser(Integer userId);

    List<Items> findBySalesAndUser(@Param("salesId") Integer salesId,@Param("userId") Integer userId);

    List<Items> findPutOff(@Param("date") String date,@Param("userId") Integer id);

    List<Items> findAllDate(@Param("date") String date,@Param("userId") Integer id);

    List<Items> findAllDone(Integer userId);

    Items findById(Integer id);

    void delete(Integer id);

    List<Items> findTaskByUserId(@Param("start") String start,@Param("end") String end, @Param("userId")Integer currentUserId);

    void done(Integer id);
}
