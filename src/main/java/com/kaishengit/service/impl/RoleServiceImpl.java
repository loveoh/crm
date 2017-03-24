package com.kaishengit.service.impl;

import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findRoleByRoleId(Integer roleid) {
        return  roleMapper.findByRoleId(roleid);
    }

    /**
     * 查询全部role
     * @return
     */
    @Override
    public List<Role> findRoleAll(){
            return roleMapper.findAll();
    }
}
