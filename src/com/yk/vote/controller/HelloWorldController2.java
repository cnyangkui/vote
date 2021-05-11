package com.yk.vote.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldController2 implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        // 设置转发视图
        httpServletRequest.getRequestDispatcher("helloworld2.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
