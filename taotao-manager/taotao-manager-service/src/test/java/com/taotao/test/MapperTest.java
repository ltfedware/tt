package com.taotao.test;

import com.github.pagehelper.PageHelper;
import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.mapper.UserMapper;
import com.taotao.manager.model.ItemCat;
import com.taotao.manager.model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * PACKAGE_NAME com.taotao.test
 * Created by ltfedware on 2017/11/9.
 */
@Ignore
public class MapperTest {
    private ApplicationContext act;


    private UserMapper userMapper;
    private ItemCatMapper itemCatMapper;


    @Before
    public void init(){
        act = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");

        userMapper = act.getBean(UserMapper.class);
        itemCatMapper = act.getBean(ItemCatMapper.class);
    }

    /****
     * insertSelective
     * 增加数据
     * 忽略空值
     */
    @Test
    public void testInsertSe0lective(){
        //创建User对象
        User user = new User();
        user.setUsername("AAAS22");
        //user.setPhone("13670081377");
        user.setEmail("ab3de@itcast.cn");
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        user.setPassword("123423789");

        //user.setId(id);
        //user.setGid(gid);


        int insert = userMapper.insertSelective(user);
        System.out.println(insert);
    }

    @Test
    public void testSelectAll(){
        int pageNum = 1;
        int pageSize = 5;
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.select(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void getById(){
        ItemCat itemCat = new ItemCat();
        //itemCat.setId(10l);
       // itemCat.setName("电脑整机");
        itemCat.setParentId(0l);
        List<ItemCat> cats = itemCatMapper.select(itemCat);
        for (ItemCat cat : cats) {
            System.out.println("-----------------"+cat.toString());

        }
    }





}
