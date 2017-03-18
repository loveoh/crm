package com.kaishengit.shiro;

import com.kaishengit.pojo.User;
import org.apache.shiro.SecurityUtils;

/**
 * Created by loveoh on 2017/1/22.
 */
public class ShiroUtil {

    public static User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getCurrentUserName(){
        return getCurrentUser().getUsename();
    }

    public static Integer getCurrentUserId(){
        return getCurrentUser().getId();
    }
}
