package com.chen.springboot_filter_demo.filter;


import org.springframework.ui.Model;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyifei
 * @version 1.0
 * @date 2022/6/7 23:09
 */
@WebFilter(urlPatterns = "/list/*", filterName = "loginFilter")
public class LoginFilter implements Filter {


    /*
     * 容器初始化
     * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=================init loginFilter=============");
    }

    /*
     * 请求拦截时调用
     * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器生效");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //req.getSession().setAttribute("username",username);//储存到session中;
        String username = (String) req.getSession().getAttribute("username");
        //String username = req.getParameter("username");
        String uri = req.getRequestURI();
        if (uri.endsWith("all.html") || uri.endsWith("all")) {
            if (null == username) {
                System.out.println("过滤器生效,未登录");
                //resp.sendRedirect("/login.html");
                req.getSession().removeAttribute("username");
                return;
            }
            System.out.println("过滤器生效，通过");
            filterChain.doFilter(req, resp);
            return;
        }
        System.out.println("过滤器生效，非来自login的请求");
        //移除session中的一条信息
        req.getSession().removeAttribute("username");
        //resp.sendRedirect("/login.html");
        return;

    }
    /**
     * 容器被销毁的时候被调用
     */
    @Override
    public void destroy() {
        System.out.println("=========================destroy loginFilter=====================");
    }

}
