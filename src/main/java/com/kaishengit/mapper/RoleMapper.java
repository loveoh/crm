package com.kaishengit.mapper;

import com.kaishengit.pojo.Role;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */

public interface RoleMapper {


    Role findByRoleId(Integer roleid);

    List<Role> findAll();
}
