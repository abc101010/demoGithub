package com.example.demoservice.service.impl;

import com.example.demoservice.data.UserInfo;
import org.springframework.stereotype.Service;

// 注册用户服务
@Service
public class UserAddService {

    /**
     * 注册用户
     * @param name 用户名字
     * @param phoneNum 电话号码
     * @return 注册的用户的信息
     */
    public UserInfo addUser(String name, String phoneNum) {
        System.out.println("注册成功");

        UserInfo userInfo = new UserInfo();
        userInfo.setId("20090");
        userInfo.setName(name + "-添加");
        userInfo.setPhoneNum(phoneNum);
        userInfo.setGender("男");

        userInfo.setId("20090");
        userInfo.setName(null);
        userInfo.setPhoneNum(phoneNum);
        userInfo.setGender("");

        return userInfo;
    }
}
