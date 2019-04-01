package com.taotao.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/14.
 */

@Controller
public class TestController {

    @RequestMapping(value = "/qq")
    public String ll(){
        return "index";
    }
}
