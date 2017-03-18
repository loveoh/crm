package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import com.kaishengit.shiro.ShiroUtil;
import com.kaishengit.util.IPUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by loveoh on 2017/3/15.
 */
@Controller
@RequestMapping("/")
public class HomeContorller {

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(){
        return "login";
    }

    @PostMapping
    public String login (String username, String password,
                         HttpServletRequest request,RedirectAttributes redirectAttributes){

        Subject subject = SecurityUtils.getSubject();

        try {
            //使用MD5对密码进行加密存储
            UsernamePasswordToken usernamePasswordToken =
                    new UsernamePasswordToken(username, DigestUtils.md5Hex(password));
            subject.login(usernamePasswordToken);

            //获取当前登录的IP，记录用户登录记录

            String ip = IPUtil.getIp(request);
            User user = ShiroUtil.getCurrentUser();
            userService.saveLoginLog(ip,user);

            return "/home";
        }catch (LockedAccountException ex){
            redirectAttributes.addFlashAttribute("message","账号被锁定");
        }catch (AuthenticationException ex){
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
        }

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout (RedirectAttributes redirectAttributes){
       SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message","你已安全退出");
        return "redirect:/";
    }

}
