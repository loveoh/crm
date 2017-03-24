package com.kaishengit.controller;

import com.kaishengit.dto.AjaxResult;
import com.kaishengit.dto.AjaxRseult;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import com.kaishengit.shiro.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by loveoh on 2017/3/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String editPassword(){
        return "setting/password";
    }

    /**
     * 远程验证原始密码是否正确
     * @return
     */
    @RequestMapping(value = "/validate/password",method = RequestMethod.GET)
    @ResponseBody
    public String validatePassword(String oldpassword){

        User user = ShiroUtil.getCurrentUser();
        oldpassword = DigestUtils.md5Hex(oldpassword);
        if (oldpassword.equals(user.getPassword())){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 重置用户密码
     * @param password
     * @return
     */
    @RequestMapping(value = "/reset/password",method = RequestMethod.POST)
    @ResponseBody
    public AjaxRseult resetPassword(String password){

       userService.resetUserPassword(password);

        return new AjaxRseult(AjaxRseult.SUCCESS);
    }

    /**
     * 跳转到用户IP 列表
     * @return
     */
    @RequestMapping(value = "/log",method = RequestMethod.GET)
    public String logList(){
        return "setting/loglist";
    }


    /**
     * 使用datatables显示IP 列表
     * @return
     */
    @RequestMapping(value = "/ip/list/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<LoginLog> load(HttpServletRequest request){
        User user = ShiroUtil.getCurrentUser();
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        List<LoginLog> loginLogList = userService.findLoginLogByQueryParam(user.getId(),start,length);
        Long count = userService.count();

        return new DataTablesResult<LoginLog>(draw,loginLogList,count,count);
    }

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    @ResponseBody
    public AjaxResult userById(@PathVariable Integer id){

        try {
            User user = userService.findById(id);
            return new AjaxResult(user);
        }catch (NotFoundException ex){
            ex.printStackTrace();
            return new AjaxResult(ex.getMessage());
        }
    }

}
