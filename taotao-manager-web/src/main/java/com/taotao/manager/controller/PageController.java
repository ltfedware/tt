package com.taotao.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/10.
 */

@Controller
@RequestMapping(value = "/page")
public class PageController {

    /**
     * '/rest/page/item-add'
     * @return
     */
    @RequestMapping(value = "/item-add")
    public String itemAdd(){
        return "item-add";
    }

    /**
     * '/rest/page/{pagename}'
     * @return
     */
    @RequestMapping(value = "/{pagename}")
    public String page(@PathVariable(value = "pagename")String pagename){
        return pagename;
    }

    @RequestMapping(value = "/qq")
    public String ll(){
        return "index";
    }

}
