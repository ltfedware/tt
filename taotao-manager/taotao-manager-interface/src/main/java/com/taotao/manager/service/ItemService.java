package com.taotao.manager.service;

import com.taotao.manager.model.Item;

/**
 * PACKAGE_NAME com.taotao.manager.service
 * Created by ltfedware on 2017/11/10.
 */
public interface ItemService extends BaseService<Item>{
    int add(Item item, String desc);
}
