package com.ghsong.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
// Web과 관련된 Bean들만 등록
@WebMvcTest
// 모든 Bean을 등록
// SpringBootTest를 사용해서 Bean을 등록하는 경우 MockMvc는 따로 등록되지 않으므로 AutoConfigureMockMvc를 추가해준다.
//@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(get("/hello")
                    .param("name", "ghsong"))
                .andDo(print())
                .andExpect(content().string("hello"));
    }

    @Test
    public void hello2() throws Exception {
        this.mockMvc.perform(get("/hello/ghsong"))
                .andDo(print())
                .andExpect(content().string("hello ghsong"));
    }
}