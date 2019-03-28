package com.ghsong.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("hello")
    public String hello() {
        return "hello, " + myService.getName();
    }
}
