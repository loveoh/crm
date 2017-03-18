package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

/**
 * Created by loveoh on 2017/3/15.
 */
public interface UserMapper {

    void saveLoginLog(String ip, Integer userid);

    User findById(Integer id);

    User findByName(String userName);

    void resetPassword(User user);

}
