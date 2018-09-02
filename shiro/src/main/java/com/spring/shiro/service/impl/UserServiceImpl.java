package com.spring.shiro.service.impl;

import com.spring.shiro.dao.UserDao;
import com.spring.shiro.model.User;
import com.spring.shiro.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Reference
    private UserDao userDao;

    @Override
    public User get(Object id) {
        return userDao.get(id);
    }
}
