package com.kaishengit.service;

import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;

import java.util.List;

/**
 * Created by loveoh on 2017/3/15.
 */
public interface UserService {
    void saveLoginLog(String ip, User user);

    User findByUserName(String userName);



    void resetUserPassword(String newpassword);

    List<LoginLog> findLoginLogByQueryParam(Integer userid,String start, String length);

    Long count();

    User findById(Integer id);
}
