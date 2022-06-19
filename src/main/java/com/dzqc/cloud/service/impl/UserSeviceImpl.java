package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.UserMapper;
import com.dzqc.cloud.entity.User;
import com.dzqc.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl implements UserService {
    @Autowired
    private UserMapper userDao;
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}