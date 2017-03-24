package com.kaishengit.service;

import com.kaishengit.pojo.Role;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
public interface RoleService {
    Role findRoleByRoleId(Integer roleid);
    List<Role> findRoleAll();
}
