package com.yk.vote.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录认证拦截器
 */
public class LoginAuthenticationHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("**************登录认证拦截***************");
        String url = request.getRequestURI();
        System.out.println(url);
        if(url.indexOf("userLogin") > 0) {
            return true;
        }
        if(url.indexOf("userRegister") > 0) {
            return true;
        }
        if(request.getSession().getAttribute("currentUser") != null) {
            return true;
        }
        if(url.indexOf("/images/") > 0) {
            return true;
        }
        if(url.indexOf("/js/") > 0) {
            return true;
        }
        if(url.indexOf("/css/") > 0) {
            return true;
        }
        response.sendRedirect("login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
