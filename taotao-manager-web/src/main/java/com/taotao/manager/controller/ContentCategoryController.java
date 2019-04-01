package com.taotao.manager.controller;

import com.taotao.manager.model.ContentCategory;
import com.taotao.manager.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/12.
 */


@Controller
@RequestMapping(value = "/content")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     *url : '/rest/content/category',
     animate: true,
     method : "GET",
     */

    @ResponseBody
    @RequestMapping(value = "/category",method = RequestMethod.GET)
    public List<ContentCategory> list(@RequestParam(value = "id",required = false,defaultValue = "0")Long id){
        /*****
         * 1、第一次加载根节点
         * 2、每次请求加载父节点的子节点
         * 	传递一个id（ID是父节点的ID）
         * 	SELECT * FROM tb_content_category WHERE parent_id=id
        */
        List<ContentCategory> list = contentCategoryService.getListByParentId(id);
        return list;
    }

    /****
     * 商品类目的增加
     * $.post("/rest/content/category/add",{parentId:node.parentId,name:node.text},function(data){
     //让编辑的树节点对象执行入下更新操作
     _tree.tree("update",{
     target : node.target,
     id : data.id	//id=新增的节点id，数据库里的id数据值
     });
     });
     */
    @ResponseBody
    @RequestMapping(value="/category/add",method=RequestMethod.POST)
    public ContentCategory add(ContentCategory contentCategory){
        //执行增加数据
        contentCategory = contentCategoryService.addContentCategory(contentCategory);
        return contentCategory;
    }



    //type: "POST",
    //url: "/rest/content/category/update",
    //data: {id:node.id,name:node.text},
    @RequestMapping(value = "/category/update",method = RequestMethod.POST)
    public ResponseEntity<String> update(ContentCategory contentCategory) throws Exception{
        try {
            int mcount = contentCategoryService.updateContentCategory(contentCategory);
            return ResponseEntity.status(HttpStatus.OK).body("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //修改失败
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }





}
