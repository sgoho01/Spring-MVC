package com.ghsong.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(Controller.class))  // 컨트롤러는 뺴고 Bean으로 등록해준다.
public class AppConfig {
    // 이 클래스는 web.xml에서 등록한 ContextLoaderListener에서 만들어줌
}
