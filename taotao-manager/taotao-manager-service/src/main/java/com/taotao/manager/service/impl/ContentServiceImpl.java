package com.taotao.manager.service.impl;

import com.github.pagehelper.PageInfo;
import com.taotao.manager.model.Content;
import com.taotao.manager.service.ContentService;

/**
 * PACKAGE_NAME com.taotao.manager.service.impl
 * Created by ltfedware on 2017/11/14.
 */
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {
    @Override
    public PageInfo<Content> getListByCategoryId(Long categoryId, Integer page, Integer rows) {
        return null;
    }
}
