package com.kaishengit.service.impl;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/24.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询user，返回datatables结果
     *
     * @param start
     * @param length
     * @param search
     * @return
     */
    @Override
    public List<User> findUsers(Integer start, Integer length, String search) {



        return userMapper.findUsers(start,length,search);
    }

    /**
     * 查处总数据 数
     * @param search
     * @return
     */
    @Override
    public Long findUsersCount(String search) {
        return userMapper.findUsersCount(search);
    }

    /**
     * 新增员工user用户,同步到微信企业号，新员工
     * @param user
     */
    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userMapper.save(user);

        //TODO 微信企业号添加新的员工
    }

    /**
     * 重置密码为 000000
     * @param id
     */
    @Override
    public User resetPassWord(Integer id) {

        User user = userMapper.findById(id);
        if(user != null){

            user.setPassword(DigestUtils.md5Hex("000000"));

            userMapper.resetPassword(user);

            return user;
        } else {
            throw new NotFoundException();
        }

    }

    @Override
	@Transactional
    public void edit(User user) {

        User user1 = userMapper.findById(user.getId());

        user.setPassword(user1.getPassword());

        userMapper.update(user);
		
		// TODO 要调用一下微信企业号，员工信息要同步到企业号
    }


}
