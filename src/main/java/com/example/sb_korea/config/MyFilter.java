package com.example.sb_korea.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hao.wong
 * @date 2021/12/14
 */
@WebFilter(urlPatterns = "/my")
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println(servletRequest.getContentType());
        System.err.println("萨迪卡大舅啊快点回家啊快点回家");
        filterChain.doFilter(servletRequest,servletResponse);
//        Filter.super.doFilter(servletRequest,servletResponse,filterChain);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
