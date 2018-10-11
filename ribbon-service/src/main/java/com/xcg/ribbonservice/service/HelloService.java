package com.xcg.ribbonservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

/**
 * @author: wb-xcg455556
 * @create: 2018/10/08
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    private final Logger LOG = Logger.getLogger(getClass());


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        Long start = System.currentTimeMillis();

        ResponseEntity<String> aa =  restTemplate.getForEntity("http://hello-service/hello",String.class);

        Long end = System.currentTimeMillis();
        LOG.info("Speed time : " + (end - start));
        return aa.getBody();
    }

    public String helloFallback(){
        return "error";
    }
}
