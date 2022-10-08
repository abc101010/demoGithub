package com.example.demoservice.service;

import com.example.demoservice.data.UserInfo;

public interface IUserService {
    /**
     * 查询用户
     * @param id  用户ID
     * @param area  区域
     * @return 查到的信息
     */
    UserInfo getUser(String id, String area);

    /**
     * 注册用户
     * @param name 用户名字
     * @param phoneNum 电话号码
     * @return 注册的用户的信息
     */
    UserInfo addUser(String name, String phoneNum);
}
