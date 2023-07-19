package com.abc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ShowInfoController
 * @Author: 青衣醉
 * @Date: 2023/3/2 9:02 下午
 */
@RestController
@RequestMapping("testInfo")
public class TestController {
    @RequestMapping("header")
    public String header(HttpServletRequest httpServletRequest){
        return "header x-reqyest-red:"+ httpServletRequest.getHeader ("x-reqyest-red");
    }
    @RequestMapping("time")
    public String context(HttpServletRequest httpServletRequest){
        return "time"+ System.currentTimeMillis ();
    }


}
