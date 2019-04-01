package com.taotao.manager.service.impl;

import com.taotao.manager.mapper.ItemDescMapper;
import com.taotao.manager.mapper.ItemMapper;
import com.taotao.manager.model.Item;
import com.taotao.manager.model.ItemDesc;
import com.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * PACKAGE_NAME com.taotao.manager.service.impl
 * Created by ltfedware on 2017/11/10.
 */
@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public int add(Item item, String desc) {
        Date date = new Date();
        long id = (long) (new Date().getTime() + Math.random() * 1000);
        //补全数据
        item.setId(id);
        item.setCreated(date);
        item.setUpdated(date);
        item.setStatus(1);
        //补全商品详情
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(id);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        itemDesc.setItemDesc(desc);
        //添加商品和商品详情
        int insert = itemMapper.insert(item);
        itemDescMapper.insert(itemDesc);
        return insert;
    }
}
