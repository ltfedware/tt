package com.taotao.manager.service;

import com.github.pagehelper.PageInfo;
import com.taotao.manager.model.Content;

/**
 * PACKAGE_NAME com.taotao.manager.service
 * Created by ltfedware on 2017/11/14.
 */
public interface ContentService extends BaseService<Content> {
    PageInfo<Content> getListByCategoryId(Long categoryId, Integer page, Integer rows);
}
