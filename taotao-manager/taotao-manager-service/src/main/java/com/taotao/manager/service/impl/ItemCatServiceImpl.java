package com.taotao.manager.service.impl;

import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.model.ItemCat;
import com.taotao.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PACKAGE_NAME com.taotao.manager.service.impl
 * Created by ltfedware on 2017/11/10.
 */
@Service
public class ItemCatServiceImpl extends BaseServiceImpl<ItemCat> implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> getListByParentId(Long id) {
        //根据父ID查询类目集合
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(id);
        return itemCatMapper.select(itemCat);
    }
}
