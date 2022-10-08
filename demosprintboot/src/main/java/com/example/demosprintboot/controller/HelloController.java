package com.example.demosprintboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    // RequestMapping 监控的路径，不能出现重复的情况
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(){

        return "Helloworld!";
    }

    @RequestMapping(value = "/sayHelloWorld", method = RequestMethod.GET)
    public String sayHello2(){

        return "Helloworld2!";
    }
}
