package com.kaishengit.mapper;

import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by loveoh on 2017/3/15.
 */
public interface UserMapper {

    void saveLoginLog(String ip, Integer userid);

    User findById(Integer id);

    User findByName(String userName);

    void resetPassword(User user);

    List<LoginLog> findLoginLogByQueryParam(Integer userid,String start, String length);

    Long count();

    List<User> findAll();

    List<User> findUsers(@Param("start") Integer start, @Param("length")Integer length, @Param("search")String search);

    Long findUsersCount(@Param("search")String search);

    void save(User user);

    void update(User user);
}
