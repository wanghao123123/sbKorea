package com.example.sb_korea.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hao.wong
 * @date 2021/12/14
 */

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("拦截起preHandle==================================");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
