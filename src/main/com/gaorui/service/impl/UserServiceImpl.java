package com.gaorui.service.impl;

import com.gaorui.dao.UserDao;
import com.gaorui.entity.User;
import com.gaorui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }
}

