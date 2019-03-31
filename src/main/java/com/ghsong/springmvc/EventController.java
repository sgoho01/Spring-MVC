package com.ghsong.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("events")
    public String events(Model model) {
        Event event1 = new Event();
        event1.setName("이벤트 1");
        event1.setStartDateTime(LocalDateTime.of(2019,03,31,10,10));
        Event event2 = new Event();
        event2.setName("이벤트 2");
        event2.setStartDateTime(LocalDateTime.of(2019,03,31,10,10));

        List<Event> events = List.of(event1, event2);

        model.addAttribute("events", events);
        model.addAttribute("message", "Hello");
        return "events/event";
    }
}
