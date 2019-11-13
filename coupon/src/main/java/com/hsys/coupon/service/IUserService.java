package com.hsys.coupon.service;

import java.util.List;

import com.hsys.coupon.entity.User;

public interface IUserService {
	int addUser(User user);
    int deleteUser(Integer id);
    User selectUser(Integer id);
    int updateUser(User user) throws Exception;
    List<User> findAll();
}
