package com.kaishengit.controller;

import com.kaishengit.dto.AjaxResult;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.service.AdminService;
import com.kaishengit.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/24.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;


    /**
     * 跳转到员工管理页面。
     * @return
     */
    @GetMapping("/users")
    public String getUsers(Model model){

        List<Role> roleList = roleService.findRoleAll();

        model.addAttribute("roleList",roleList);

        return "admin/userlist";
    }


    /**
     *      * 接受，datatables表单发送的ajax
     * @param draw 第几次请求
     * @param start 开始行
     * @param length 查几个
     * @param search 搜索内容，员工姓名或者登录帐号
     * @return
     */
    @PostMapping("/users/data.json")
    @ResponseBody
    public DataTablesResult getUsers(String draw, Integer start,
                                     Integer length, @RequestParam(value = "search[value]") String search){

        Long total = adminService.findUsersCount(search);

        List<User> userList = adminService.findUsers(start,length,search);

        return new DataTablesResult<User>(draw,userList,total,total);
    }


    /**
     * 新增员工
     * @param user
     * @return
     */
    @PostMapping("/save")
    public String save(User user){

        adminService.saveUser(user);

        return "redirect:/admin/users";
    }

    /**
     * 重置密码为 000000
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}/resetPassWord")
    @ResponseBody
    public AjaxResult resetPassWord(@PathVariable Integer id){

        try {
            User user = adminService.resetPassWord(id);
            return new AjaxResult(AjaxResult.SUCCESS,user.getRealname());
        } catch (NotFoundException ex){
            ex.printStackTrace();
            logger.error(ex.getMessage());
            return new AjaxResult(ex.getMessage());
        }

    }

    /**
     * 修改
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(User user){
        adminService.edit(user);
        return  new AjaxResult(user);
    }

}
