package com.taotao.manager.service;

import com.taotao.manager.model.ContentCategory;

/**
 * PACKAGE_NAME com.taotao.manager.service
 * Created by ltfedware on 2017/11/14.
 */
public interface ContentCategoryService extends BaseService<ContentCategory> {
    ContentCategory addContentCategory(ContentCategory contentCategory);

    int updateContentCategory(ContentCategory contentCategory);
}
