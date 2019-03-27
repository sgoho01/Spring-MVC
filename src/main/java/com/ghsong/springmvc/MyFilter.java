package com.ghsong.springmvc;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter");

        // 서블릿으로 연결하려면 다음 체인으로 연결해 줘야 한다.
        filterChain.doFilter(servletRequest, servletResponse);
        // 해당 필터가 마지막 필터인 경우 doFilter는 서블릿으로 연결시켜 준다.
    }

    @Override
    public void destroy() {
        System.out.println("Filter destory");
    }
}
