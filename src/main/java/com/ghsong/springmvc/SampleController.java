package com.ghsong.springmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// 해당 컨트롤러에서는 전부 GET HTTP Method 사용
//@RequestMapping(method = RequestMethod.GET)
// 클래스에 적용하게 되면 전부 해당 consumes 로 적용된다. 메소드에 새로 적게되면 consumes를 오버라이딩하여 클래스의 설정은 무효가 된다.
//@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SampleController {

    /*
     * ### 1.HTTP 요청 맵핑 : 요청 메소드
     * 특정 HTTP Method만 받고싶은경우 method에 특정 메소드 요청을 입력
     * @RequestMapping(value = "/hello", method = RequestMethod.GET)
     */
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello() {
        return "hello";
    }

    /*
     * ### 2.HTTP 요청 맵핑 : URI 패턴 맵핑
     */
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

    /*
     * ### 3.HTTP 요청 맵핑 : 컨텐츠 타입 맵핑
     */
    @RequestMapping(value = "/wellcome", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String wellcome() {
        return "wellcome";
    }

}
