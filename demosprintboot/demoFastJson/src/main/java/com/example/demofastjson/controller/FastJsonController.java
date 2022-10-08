package com.example.demofastjson.controller;

import com.example.demofastjson.data.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FastJsonController {

    @GetMapping("/getUserJson")
    public UserInfo getUserJson() {

        UserInfo userInfo = new UserInfo();
        userInfo.setId("2006");
        userInfo.setName("王武");
        userInfo.setGender(null);

        return userInfo;
    }

    // localhost:9011/getUserJsonList/101012/大连
    // 使用RestFul风格API，取得列表对象json形式数据
    // 得到的结果： [{"id":"2006","Name":"王武","gender":"男"},{"id":"2007","Name":"赵六","gender":"男"}]
    @GetMapping("/getUserJsonList/{id}/{area}")
    public List<UserInfo> getUserJsonList(@PathVariable("id") String id,
                                          @PathVariable("area") String area) {
        return null;
    }

    // localhost:9011/getUserJsonMap/101012/大连
    // 使用RestFul风格API，取得列表对象json形式数据
    // 得到的结果： {
    //              "主页地址":"http://www.baidu.com",
    //              "user":{"id":"2006","gender":"男","name":"王武"},
    //              "描述":"最受欢迎的主播",
    //              "粉丝量":45623
    //             }
    @GetMapping("/getUserJsonMap/{id}/{area}")
    public Map<String, Object> getUserJsonMap(@PathVariable("id") String id,
                                              @PathVariable("area") String area) {

        Map<String, Object> map = new HashMap<>(5);
        UserInfo userInfo = new UserInfo("2006", "王武", "男");
        map.put("user", userInfo);
        map.put(null, null);
        map.put("主页地址", "http://www.baidu.com");
        map.put("粉丝量", 45623);

        return map;
    }
}
