package com.ghsong.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEvents() throws Exception {
        this.mockMvc.perform(get("/events"))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void getEventsWithId() throws Exception {
        this.mockMvc.perform(get("/events/1"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/events/2"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/events/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void createEvent() throws Exception {
        this.mockMvc.perform(post("/events")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void removeEvent() throws Exception {
        this.mockMvc.perform(delete("/events/1"))
                .andExpect(status().isOk());
        this.mockMvc.perform(delete("/events/2"))
                .andExpect(status().isOk());
        this.mockMvc.perform(delete("/events/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateEvents() throws Exception {
        this.mockMvc.perform(put("/events/1")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        this.mockMvc.perform(put("/events/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}