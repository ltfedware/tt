package com.taotao.manager.service.impl;

import com.taotao.manager.mapper.UserMapper;
import com.taotao.manager.model.User;
import com.taotao.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PACKAGE_NAME com.taotao.manager.service.impl
 * Created by ltfedware on 2017/11/7.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUser(long id) {
        return userMapper.getUser(id);
    }

    @Override
    public void deleteUser(long id) {
        userMapper.deleteUser(id);
    }
}
