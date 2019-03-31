package com.ghsong.springmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Autowired
    ObjectMapper objectMapper;

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

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Wellcome")));
    }
    @Test
    public void helloStatic2() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Wellcome")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL))
                ;
    }

    @Test
    public void message() throws Exception {
        this.mockMvc.perform(get("/message")
                    .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
        ;
    }

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(1l);
        person.setName("song");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

}