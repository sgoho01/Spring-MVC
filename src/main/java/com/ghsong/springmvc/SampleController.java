package com.ghsong.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// 해당 컨트롤러에서는 전부 GET HTTP Method 사용
//@RequestMapping(method = RequestMethod.GET)
public class SampleController {

    // 특정 HTTP Method만 받고싶은경우 method에 특정 메소드 요청을 입력
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping({"/hello2", "/hi"})
    @ResponseBody
    public String hello2() {
        return "hello2";
    }

    @RequestMapping("/hello/{name:[a-z]+}")
    @ResponseBody
    public String hello3(@PathVariable String name) {
        return "hello3 " + name;
    }



}
