package com.kaishengit.service.impl;

import com.kaishengit.controller.HomeContorller;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import com.kaishengit.shiro.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loveoh on 2017/3/15.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(HomeContorller.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public void saveLoginLog(String ip, User user) {
        userMapper.saveLoginLog(ip,user.getId());

        logger.info("{}登录了系统，ip为{}",user.getUsename(),ip);
    }

    @Override
    public User findByUserName(String userName) {

        return userMapper.findByName(userName);
    }

    @Override
    public void resetUserPassword(String newpassword) {
        User user = ShiroUtil.getCurrentUser();
        user.setPassword(newpassword);
        userMapper.resetPassword(user);
    }

    /**
     * 查询登录log页面
     * @param start
     * @param length
     * @return
     */
    @Override
    public List<LoginLog> findLoginLogByQueryParam(Integer userid,String start, String length) {

        return userMapper.findLoginLogByQueryParam(userid,start,length);
    }

    /**
     * IP显示也面的总数
     * @return
     */
    @Override
    public Long count() {
        return userMapper.count();
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {

        User user = userMapper.findById(id);

        if(user != null){
            return user;
        } else {
            throw  new NotFoundException();
        }
    }


}
