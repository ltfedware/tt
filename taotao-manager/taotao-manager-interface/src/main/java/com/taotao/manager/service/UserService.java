package com.taotao.manager.service;

import com.taotao.manager.model.User;

/**
 * PACKAGE_NAME com.taotao.manager.service
 * Created by ltfedware on 2017/11/7.
 */
public interface UserService extends BaseService<User> {


    void add(User user);

    void updateUser(User user);

    User getUser(long id);

    void deleteUser(long id);
}
