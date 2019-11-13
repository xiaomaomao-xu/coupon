package com.hsys.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsys.coupon.entity.User;
import com.hsys.coupon.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
    private IUserService userService;
 
    @RequestMapping(value = "/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
 
    @RequestMapping(value = "add")
    public int addUser(){
        User u = new User(null,"oooo",45);
        int stat = userService.addUser(u);
        return stat;
    }
    
    @RequestMapping(value = "update")
    public int updateUser(){
        User u = new User(99,"oooo",899);
        int stat = 0;
		try {
			stat = userService.updateUser(u);
		} catch (Exception e) {
			System.out.println("我报错了呦");
		}
        return stat;
    }
}
