package com.taotao.manager.service;

import com.taotao.manager.model.ItemCat;

import java.util.List;

/**
 * PACKAGE_NAME com.taotao.manager.service
 * Created by ltfedware on 2017/11/10.
 */
public interface ItemCatService extends BaseService<ItemCat>{
    List<ItemCat> getListByParentId(Long id);
}
