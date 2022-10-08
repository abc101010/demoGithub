package com.example.demosprintboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInformationController {

    @Value("${bootInfo.appName}")
    private String showName;

    @Value("${server.port}")
    private String port;

    // localhost:9010/getUserRest/101012/大连
    // 使用注解 PathVariable，在RestFul风格的url中，取得路径参数
    @GetMapping("/getUserRest/{id}/{area}")
    public String getUserRest(@PathVariable("id") String id,
                              @PathVariable("area") String area) {

        return "restFul 风格：李四，ID：" + id + " 地区：" + area;
    }

    // localhost:9010/getUser2?sign=101012&area=大连
    // 使用注解RequestParam，对路径参数与响应函数参数进行映射
    @GetMapping("/getUser2")
    public String getUser2(@RequestParam("sign") String id, String area) {

        return "李四2233，ID：" + id + " 地区：" + area;
    }

    // localhost:9010/getUser?id=101012&area=大连
    // 路径参数名称与响应函数的参数名称，必须一致的，并且区分大小写
    @GetMapping("/getUser")
    public String getUser(String id, String area) {

        return "张三，ID：" + id + " 地区：" + area;
    }

    @GetMapping("/applicationInfo")
    public String getApplicationInfo() {

        return "系统常量：" + showName + " 端口号：" + port;
    }
}
