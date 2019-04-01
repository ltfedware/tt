package com.taotao.manager.controller;


import com.github.pagehelper.PageInfo;
import com.taotao.manager.model.User;
import com.taotao.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/7.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add")
    public String add(){
        User user = new User();
        user.setUsername("李帅发");
        user.setPhone("13670081371");
        user.setEmail("abc@itcast.cn");
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        user.setPassword("123456");

        userService.add(user);
        return "index";
    }


    /***
     * 查询数据
     * @return
     */
    @RequestMapping(value="/query")
    public String getUser(){
        //根据ID查询数据
        long id = 44l;
        User user = userService.getUser(id);

        System.out.println(user);
        return "index";
    }

    @RequestMapping(value = "/update")
    public String updateUset(){
        User user = new User();
        user.setUsername("李志发");
        user.setId(44l);
        userService.updateUser(user);
        return "index";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(){
       long id = 44l;
        userService.deleteUser(id);
        return "index";
    }

    @RequestMapping(value = "/list/{pagenum}")
    public String list(@PathVariable(value = "pagenum")Integer pagenum){
        int pageSize = 5;
        PageInfo<User> pageInfo = userService.getPageList(pagenum, pageSize);
        //获取集合信息
        List<User> list = pageInfo.getList();

        for (User user : list) {
            System.out.println(user);
        }

        System.out.println("总共有"+pageInfo.getLastPage()+"页!");
        return "index";
    }
}
