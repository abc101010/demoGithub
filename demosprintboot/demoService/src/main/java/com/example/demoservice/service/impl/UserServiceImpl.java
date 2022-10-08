package com.example.demoservice.service.impl;

import com.example.demoservice.data.UserInfo;
import com.example.demoservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserSearchService userInfo;
    @Autowired
    public UserAddService userAdd;
    /**
     * 查询用户
     *
     * @param id   用户ID
     * @param area 区域
     * @return 查到的信息
     */
    public UserInfo getUser(String id, String area) {

        return userInfo.getUser(id, area);
    }

    /**
     * 注册用户
     *
     * @param name     用户名字
     * @param phoneNum 电话号码
     * @return 注册的用户的信息
     */
    public UserInfo addUser(String name, String phoneNum) {

        return userAdd.addUser(name, phoneNum);
    }
}
