package com.taotao.manager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.fdfs.FastDFSUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * PACKAGE_NAME com.taotao.manager.controller
 * Created by ltfedware on 2017/11/11.
 */

@Controller
@ResponseBody
@RequestMapping(value = "/pic")
public class UploadController {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${FastDFS_Tracker_Server_Conf}")
    private String FastDFS_Tracker_Server_Conf;

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String UploadController(@RequestParam(value = "uploadFile")MultipartFile file,
                                   HttpSession session) throws Exception {


        String subfix = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");

        //上传
        String[] strings = FastDFSUtils.upload(FastDFS_Tracker_Server_Conf,file.getBytes(), subfix);
        //回显数据    JSON
        //   error:0 表示成功，大于0表示失败
        //   url:图片回显路径
        //   width：宽度
        //   height：高度
        Map<String, Object> dateMap = new HashMap<String, Object>();
        dateMap.put("error",0 );
        dateMap.put("width",100 );
        dateMap.put("height",100 );
        //组名：group1  string[0]
        //路径: M00/00/00/wKgZhVoH9PmAQvkyAAB_KakLdsY222.jpg string[1]
        dateMap.put("url", "http://192.168.25.133/"+strings[0]+"/"+strings[1]);
        String json = objectMapper.writeValueAsString(dateMap);
        return json;
    }


    /**
     * 基于SpringMVC文件上传
     * @param file
     * @param session
     * @return
     * @throws Exception
     */
    // filePostName  : "uploadFile",
    //uploadJson : '/rest/pic/upload',
    @ResponseBody
    @RequestMapping(value = "/springmvcupload",method = RequestMethod.POST)
    public String Uploadspringmvc(@RequestParam(value = "uploadFile")MultipartFile file,
                                   HttpSession session) throws Exception {
        ////获取upload目录
        String path = session.getServletContext().getRealPath("/upload");
        //获取后缀
        String filename = file.getOriginalFilename();
        String subfix = StringUtils.substringAfterLast(filename, ".");
        //设置文件存储的名字
        String finalName = UUID.randomUUID()+"."+subfix;
        //上传
        file.transferTo(new File(path+"/"+finalName));
        //回显数据    JSON
        //   error:0 表示成功，大于0表示失败
        //   url:图片回显路径
        //   width：宽度
        //   height：高度
        Map<String, Object> dateMap = new HashMap<String, Object>();
        dateMap.put("error",0 );
        dateMap.put("width",100 );
        dateMap.put("height",100 );
        dateMap.put("url", "http://www.taotao.com/upload/"+finalName);
        String json = objectMapper.writeValueAsString(dateMap);
        return json;
    }
}
