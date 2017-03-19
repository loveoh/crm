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


    public static String getCurrentRealName() {
        return getCurrentUser().getRealname();
    }

    public static boolean isAdmin() {
        return getCurrentUser().getRole().getRoleName().equals("管理员");
    }

    public static boolean isEmployee() {
        return getCurrentUser().getRole().getRoleName().equals("员工");
    }

    public static boolean isManager() {
        return getCurrentUser().getRole().getRoleName().equals("经理");
    }
}
