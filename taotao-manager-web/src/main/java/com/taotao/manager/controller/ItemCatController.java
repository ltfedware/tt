package com.taotao.manager.controller;

import com.taotao.manager.model.ItemCat;
import com.taotao.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/10.
 */
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    // url:'/rest/item/cat?id={nodeId}',
    // method:'GET',
    // 第一次请求是没有id参数，需要设置默认的parentId为0，查询一级类目

    @RequestMapping(value = "/item/cat",method = RequestMethod.GET)
    @ResponseBody
    public List<ItemCat> list(@RequestParam(value = "id",required = false,defaultValue = "0")Long id){
        List<ItemCat> list =  itemCatService.getListByParentId(id);

        return list;
    }
}
