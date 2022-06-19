package com.dzqc.cloud.controller;

import com.dzqc.cloud.entity.User;
import com.dzqc.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public User insertUser(@RequestBody User user){
        int x = userService.insertUser(user);
        return user;
    }
}