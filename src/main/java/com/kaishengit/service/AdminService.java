package com.kaishengit.service;

import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/24.
 */
public interface AdminService {
    List<User> findUsers( Integer start, Integer length, String search);

    Long findUsersCount(String search);


    void saveUser(User user);

    User resetPassWord(Integer id);

    void edit(User user);
}
