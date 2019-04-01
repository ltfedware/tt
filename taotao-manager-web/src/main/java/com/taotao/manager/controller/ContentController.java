package com.taotao.manager.controller;

import com.github.pagehelper.PageInfo;
import com.taotao.manager.model.Content;
import com.taotao.manager.service.ContentServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/14.
 */

@Controller
public class ContentController {
    @Autowired
    private ContentServi contentService;

    /***
     * rows
     * total
     *
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/content",method= RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(value="categoryId",required=false,defaultValue="0")Long categoryId,
                                    @RequestParam(value="page",required=false,defaultValue="1")Integer page,
                                    @RequestParam(value="rows",required=false,defaultValue="10")Integer rows){
        //定义一个Map对象，存储rows、total转化后的json数据
        Map<String, Object> dataMap = new HashMap<String,Object>();

        //根据类目ID查询数据
        PageInfo<Content> pageInfo = contentService.getListByCategoryId(categoryId,page,rows);

        dataMap.put("total", pageInfo.getTotal());
        dataMap.put("rows", pageInfo.getList());
        return dataMap;
    }
}
