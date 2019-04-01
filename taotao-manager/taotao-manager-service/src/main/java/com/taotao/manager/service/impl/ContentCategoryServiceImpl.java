package com.taotao.manager.service.impl;

import com.taotao.manager.mapper.ContentCategoryMapper;
import com.taotao.manager.model.ContentCategory;
import com.taotao.manager.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * PACKAGE_NAME com.taotao.manager.service.impl
 * Created by ltfedware on 2017/11/14.
 */
@Service
public class ContentCategoryServiceImpl extends BaseServiceImpl<ContentCategory> implements ContentCategoryService {
    @Autowired
    private ContentCategoryMapper contentCategoryMapper;
    @Override
    public ContentCategory addContentCategory(ContentCategory contentCategory) {
        //数据补全
        contentCategory.setStatus(1);
        contentCategory.setIsParent(false);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(contentCategory.getCreated());

        //执行增加
        contentCategoryMapper.insertSelective(contentCategory);

        //判断父节点原来是否是父节点，如果不是，则修改成父节点
        ContentCategory parent = new ContentCategory();
        parent.setId(contentCategory.getParentId());
        parent = contentCategoryMapper.selectOne(parent);
        if(!parent.getIsParent()){
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKeySelective(parent);
        }

        return contentCategory;

    }

    @Override
    public int updateContentCategory(ContentCategory contentCategory) {
        contentCategory.setUpdated(new Date());
        return contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
    }
}
