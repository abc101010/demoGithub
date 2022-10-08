package com.example.demosprintboot.controller;

import com.example.demosprintboot.data.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerController {

    // localhost:9010/getJsonWithController
    @GetMapping("/getJsonWithController")
    @ResponseBody
    public UserInfo sayHello(){

        UserInfo userInfo = new UserInfo();
        userInfo.setId("2006");
        userInfo.setName("王武");
        userInfo.setGender("男");

        return userInfo;
    }
}
