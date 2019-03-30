package com.ghsong.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// 기본 스캔 설정 False. 컨트롤러인 경우에만 컴포넌트 스캔하여 빈으로 등록
//@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
@ComponentScan
public class WebConfig {


    // ModelAndView를 리턴할때 view의 경로의 prefix, suffix를 설정
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return  viewResolver;
    }
}
