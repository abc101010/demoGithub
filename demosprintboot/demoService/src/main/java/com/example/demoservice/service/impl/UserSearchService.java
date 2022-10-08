package com.example.demoservice.service.impl;

import com.example.demoservice.data.UserInfo;
import org.springframework.stereotype.Service;

// 查询用户服务
@Service
public class UserSearchService {

    /**
     * 查询用户
     * @param id  用户ID
     * @param area  区域
     * @return 查到的信息
     */
    public UserInfo getUser(String id, String area) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("2009");
        userInfo.setName("王武-服务");
        userInfo.setGender("男");

        return userInfo;
    }
}
