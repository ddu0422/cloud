package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
// @Controller + @ResponseBody와 동일
@RestController
public class HelloController {

    // @RequestMapping(method = RequestMethod.GET)으로 사용되었다.
    // /hello 요청이 오면 문자열 hello를 반환한다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
