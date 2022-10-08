package com.example.demosession.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器的定义
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;

        try{
            if (request.getSession().getAttribute("uid") != null){

                result = true;
            } else{

                result = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
