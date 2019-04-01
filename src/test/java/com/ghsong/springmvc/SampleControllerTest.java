package com.ghsong.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(post("/hello.json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                ;
    }

    @Test
    public void hello2Test() throws Exception {
        this.mockMvc.perform(get("/hi"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    public void hello3Test() throws Exception {
        this.mockMvc.perform(get("/hello/ghsong"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello3 ghsong"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("hello3"))
                ;
    }

    @Test
    public void wellcomeTest() throws Exception {
        this.mockMvc.perform(get("/wellcome")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }


}