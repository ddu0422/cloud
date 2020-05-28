package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
// SpringRunner라는 스프링 실행자를 사용
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@RunWith(SpringRunner.class)

// Web(SpringMVC)에 집중할 수 있는 Annotation
// @Controller, @AdviceController를 사용할 수 있다.
// @Service, @Repository, @Component는 사용할 수 없다.
@WebMvcTest
public class HelloControllerTest {

    // 스프링이 관리하는 Bean을 주입
    @Autowired

    // 웹 API를 테스트할 때 사용
    // 스프링 MVC 테스트의 시작점
    // HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
    private MockMvc mockMvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청
        // 체이닝이 지원
        mockMvc.perform(get("/hello"))
                // mockMvc.perform()의 결과를 검증
                // HTTP Header의 Status를 검증 200, 400, 404, 500 등
                .andExpect(status().isOk())
                // mockMvc.perform()의 결과를 검증
                // 응답 본문의 내용을 검즘
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(
                get("/hello2")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
