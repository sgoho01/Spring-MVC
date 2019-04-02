package com.ghsong.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

// 이 애노테이션이 어디까지 유지할것인가
// RUNTIME 앱이 실행될 때 까지
@Retention(RetentionPolicy.RUNTIME)
// 해당 애노테이션을 어디에 사용할 수 있는지
@Target(ElementType.METHOD)
// 코드 문서에 남아서 표시되는지
@Documented
@RequestMapping(method = RequestMethod.GET, value = "/hello6")
public @interface GetHelloMapping {
}
