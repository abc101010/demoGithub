package com.example.demojsonresult.controller;

import com.example.demojsonresult.common.JsonResult;
import com.example.demojsonresult.data.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JsonController {

    // localhost:9012/addUser
    // 使用RestFul风格API，取得单一对象json形式数据
    // 得到的结果： {"data":{"id":"2006","gender":"男","name":"王武"},"code":"0","msg":"操作成功"}
    // 格式化：{
    //          "data":{"id":"2006","gender":"男","name":"王武"},
    //          "code":"0",
    //          "msg":"操作成功"
    //         }
    @PostMapping("/addUser")
    // @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public JsonResult<UserInfo> addUser(@RequestBody UserInfo user) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId("20061");
        userInfo.setName(user.getName() + "-服务器确认");
        userInfo.setGender(user.getGender());

        return new JsonResult<>(userInfo);
    }

    // localhost:9012/getUserJson/101012/大连
    // 使用RestFul风格API，取得单一对象json形式数据
    // 得到的结果： {"data":{"id":"2006","gender":"男","name":"王武"},"code":"0","msg":"操作成功"}
    // 格式化：{
    //          "data":{"id":"2006","gender":"男","name":"王武"},
    //          "code":"0",
    //          "msg":"操作成功"
    //         }
    @GetMapping("/getUserJson/{id}/{area}")
    public JsonResult<UserInfo> getUserJson(@PathVariable("id") String id,
                                @PathVariable("area") String area) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId("2006");
        userInfo.setName("王武");
        userInfo.setGender("男");

        return new JsonResult<>(userInfo);
    }

    // localhost:9012/getUserJsonPara
    // 使用RestFul风格API，取得单一对象json形式数据
    // 得到的结果： {"data":{"id":"2006","gender":"男","name":"王武"},"code":"0","msg":"操作成功"}
    // 格式化：{
    //          "data":{"id":"2006","gender":"男","name":"王武"},
    //          "code":"0",
    //          "msg":"操作成功"
    //         }
    @GetMapping("/getUserJsonPara")
    public JsonResult<UserInfo> getUserJsonPara(String id, String area) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId("2009");
        userInfo.setName("王武2");
        userInfo.setGender("男");

        return new JsonResult<>(userInfo);
    }

    // localhost:9012/getUserJsonList/101012/大连
    // 使用RestFul风格API，取得列表对象json形式数据
    // 得到的结果： {"data":[{"id":"2006","gender":"男","name":"王武"},{"id":"2008","gender":"男","name":"赵六"}],"code":"0","msg":"操作成功"}
    // 格式化：{
    //          "data":[{"id":"2006","gender":"男","name":"王武"},{"id":"2008","gender":"男","name":"赵六"}],
    //          "code":"0",
    //          "msg":"操作成功"
    //        }
    @GetMapping("/getUserJsonList/{id}/{area}")
    public JsonResult<List> getUserJsonList(@PathVariable("id") String id,
                                          @PathVariable("area") String area) {

        List<UserInfo> userInfoList= new ArrayList<>();

        UserInfo userInfo = new UserInfo("2006", "王武", "男");
        userInfoList.add(userInfo);

        UserInfo userInfo2 = new UserInfo("2008", "赵六", "男");
        userInfoList.add(userInfo2);

        return new JsonResult<>(userInfoList);
    }

    // localhost:9012/getUserJsonMap/101012/大连
    // 使用RestFul风格API，取得列表对象json形式数据
    // 得到的结果： {"data":{"主页地址":"http://www.baidu.com","user":{"id":"2006","gender":"男","name":"王武"},"描述":"最受欢迎的主播","粉丝量":45623},"code":"0","msg":"操作成功"}
    // 格式化：{
    //          "data":{"主页地址":"http://www.baidu.com","user":{"id":"2006","gender":"男","name":"王武"},"描述":"最受欢迎的主播","粉丝量":45623},
    //          "code":"0",
    //          "msg":"操作成功"
    //         }
    @GetMapping("/getUserJsonMap/{id}/{area}")
    public  JsonResult<Map> getUserJsonMap(@PathVariable("id") String id,
                                          @PathVariable("area") String area) {

        Map<String, Object> map = new HashMap<>(5);
        UserInfo userInfo = new UserInfo("2006", "王武", "男");
        map.put("user", userInfo);
        map.put("描述", "最受欢迎的主播");
        map.put("主页地址", "http://www.baidu.com");
        map.put("粉丝量", 45623);

        return new JsonResult<>(map);
    }

    // localhost:9012/getUserJsonFail/101012/大连
    // 使用RestFul风格API，取得列表对象json形式数据
    // 得到的结果： {"data":null,"code":"50","msg":"数据请求失败！"}
    // 格式化：{
    //          "data":null,
    //          "code":"50",
    //          "msg":"数据请求失败！"
    //        }
    @GetMapping("/getUserJsonFail/{id}/{area}")
    public  JsonResult<Map> getUserJsonFail(@PathVariable("id") String id,
                                           @PathVariable("area") String area) {

        return (JsonResult)(new JsonResult<>("50", "数据请求失败！"));
    }
}
