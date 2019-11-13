package com.hsys.coupon.dao;

import java.util.List;

import com.hsys.coupon.entity.User;
 
public interface UserMapper {
    int insertUser(User user);
    int deleteUser(Integer id);
    User selectUser(Integer id);
    int updateUser(User user);
    List<User> selectAll();
}