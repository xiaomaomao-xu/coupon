package com.hsys.coupon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsys.coupon.dao.UserMapper;
import com.hsys.coupon.entity.User;
import com.hsys.coupon.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
    private UserMapper userMapper;
 
    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }
 
    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
 
    @Override
    public User selectUser(Integer id) {
        return userMapper.selectUser(id);
    }
 
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
 
    @Override
    @Transactional
    public int updateUser(User user) throws Exception {
    	int updateUser = userMapper.updateUser(user);
    	if(updateUser > 0) {
    		throw new RuntimeException("提现失败");
    	}
        return updateUser;
    }
	
}
