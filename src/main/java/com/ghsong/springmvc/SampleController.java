package com.ghsong.springmvc;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /*
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
    */

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person) {
        return "hello " + person.getName();
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam("name") String name) {
        return "hello " + name;
    }


    @GetMapping("/message")
    @ResponseBody
    public String message(@RequestBody String body) {

        return body;
    }


}
