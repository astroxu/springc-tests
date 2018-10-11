package com.xcg.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wb-xcg455556
 * @create: 2018/10/09
 **/
@RefreshScope
@RestController
public class TestController {

   /* @Value("${from}")
    private String from;*/

   @Autowired
   private Environment environment;

    @RequestMapping("/from")
    public String from(){
        //return this.from;
        return environment.getProperty("from","undefined");
    }

}
