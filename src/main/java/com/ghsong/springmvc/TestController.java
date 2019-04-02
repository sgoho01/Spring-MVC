package com.ghsong.springmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String events(@PathVariable("id") int id) {
        return "events";
    }

    @PostMapping(
            value = "/events",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String createEvent() {
        return "event";
    }

    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String removeEvent(@PathVariable int id) {
        return "event";
    }

    @PutMapping(value = "/events/{id}"
    ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String updateEvent(@PathVariable int id) {
        return "events";
    }
}
