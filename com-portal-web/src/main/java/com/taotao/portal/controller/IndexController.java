package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PACKAGE_NAME com.taotao.portal.controller
 * Created by ltfedware on 2017/11/12.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
