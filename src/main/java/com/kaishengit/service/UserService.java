package com.kaishengit.service;

import com.kaishengit.pojo.User;

/**
 * Created by loveoh on 2017/3/15.
 */
public interface UserService {
    void saveLoginLog(String ip, User user);

    User findByUserName(String userName);



    void resetUserPassword(String password);
}
