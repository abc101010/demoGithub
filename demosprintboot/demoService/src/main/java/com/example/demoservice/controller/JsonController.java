package com.example.demoservice.controller;

import com.example.demoservice.common.JsonResult;
import com.example.demoservice.data.UserInfo;
import com.example.demoservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JsonController {

    @Autowired
    public UserServiceImpl userService;

    // localhost:9013/addUser
    // 使用RestFul风格API，取得单一对象json形式数据
    // post 参数：
    // {
    //    "name":"王武",
    //    "phoneNum":"13012345678"
    //}
    // 格式化后的结果：{
    //    "data": {
    //        "id": "20090",
    //        "phoneNum": "13012345678",
    //        "gender": "男",
    //        "name": "王武-添加"
    //    },
    //    "code": "0",
    //    "msg": "操作成功"
    //}
    @PostMapping("/addUser")
    public JsonResult<UserInfo> addUser(@RequestBody UserInfo user) {

        UserInfo userInfo = userService.addUser(user.getName(), user.getPhoneNum());

        return new JsonResult<>(userInfo);
    }

    // localhost:9013/getUserJsonPara/101012/大连
    // 使用RestFul风格API，取得单一对象json形式数据
    // 得到的结果： {"data":{"id":"2009","gender":"男","name":"王武-服务"},"code":"0","msg":"操作成功"}
    // 格式化：{
    //          "data":{"id":"2009","gender":"男","name":"王武-服务"},
    //          "code":"0",
    //          "msg":"操作成功"
    //         }
    @GetMapping("/getUserJsonPara/{id}/{area}")
    public JsonResult<UserInfo> getUserJsonPara(@PathVariable("id") String id,
                                                @PathVariable("area") String area) {

        // ------------------------------------
        // 调用举例
        // 1、父控制器-银行金额检查 (门面/外观模式)
        // 1.1 储蓄卡
        // 1.2 信用卡
        // 1.3 花呗

        // ------------------------------------
        // 1、用户管理服务 - UserService
        // 1.1 注册服务 - UserAddService
        // 1.2 查询服务 - UserSearchService

        UserInfo userInfo = userService.getUser(id, area);

        return new JsonResult<>(userInfo);
    }
}
