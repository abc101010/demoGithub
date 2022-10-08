package com.example.demosession.controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class JsonController {

    // localhost:9016/login/10
    @GetMapping("/login/{id}")
    public String login(HttpServletRequest request, @PathVariable("id") int id) {

        request.getSession().setAttribute("uid", id);

        return "登录成功";
    }

    // localhost:9016/userInfo/10
    @GetMapping("/userInfo/{id}")
    public String userInfo(HttpServletRequest request, @PathVariable("id") int id) {
//        if (request.getSession().getAttribute("uid") != null){
//
//            return "用户信息";
//        } else{
//
//            return "用户信息取得失败！";
//        }

        return "用户信息";
    }

    // localhost:9016/logout/10
    @GetMapping("/logout/{id}")
    public String logout(HttpServletRequest request, @PathVariable("id") int id) {

        request.getSession().invalidate();

        return "退出成功";
    }

}
