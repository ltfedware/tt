package com.taotao.manager.controller;

import com.github.pagehelper.PageInfo;
import com.taotao.manager.model.Item;
import com.taotao.manager.service.ItemService;
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
 * Created by ltfedware on 2017/11/10.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;


    //url:'/rest/item',method:'get',pageSize:30  total=数据总记录、rows=数据集合
    @RequestMapping(value = "/item",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> itemList(@RequestParam(value = "page")Integer pageNum,
                           @RequestParam(value = "rows")Integer pageSize){
        PageInfo<Item> pageInfo = itemService.getPageList(pageNum, pageSize);
        Map<String,Object> dateMap = new HashMap<String,Object>();
        dateMap.put("total", pageInfo.getTotal());
        dateMap.put("rows", pageInfo.getList());

        return dateMap;
    }



    /**
     * //type: "POST",
     * //url: "/rest/item",
     * //data: $("#itemAddForm").serialize(),
     * @param item
     * @param desc
     * @return
     */
    @RequestMapping(value = "/item",method = RequestMethod.POST)
    @ResponseBody
    public String  add(Item item, String desc){

        try {
            int acount = itemService.add(item,desc);
            if(acount>0){
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
             return "error";
    }
   /* @RequestMapping(value="/item",method=RequestMethod.POST)
    public ResponseEntity<String> add(Item item, String desc){
        try {
            int acount = itemService.addItem(item, desc);

            if (acount > 0) {
                return ResponseEntity.status(HttpStatus.OK).body("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }*/
}
