package com.taotao.manager.mapper;

import com.github.abel533.mapper.Mapper;
import com.taotao.manager.model.User;

/**
 * PACKAGE_NAME com.taotao.manager.mapper
 * Created by ltfedware on 2017/11/7.
 */
public interface UserMapper extends Mapper<User>{
    /**
     * 添加数据
     * @param user
     */
    void add(User user);

    /**
     * 更新数据
     * @param user
     */
    void updateUser(User user);

    User getUser(long id);

    /**
     * 删除数据
     * @param id
     */
    void deleteUser(long id);
}
