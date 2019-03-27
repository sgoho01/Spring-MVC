package com.ghsong.springmvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 컨텍스트 생성 시
        System.out.println("Context Initialized");
        sce.getServletContext().setAttribute("name", "ghsong");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 컨텍스트 종료 시
        System.out.println("Context Destory");

    }
}
