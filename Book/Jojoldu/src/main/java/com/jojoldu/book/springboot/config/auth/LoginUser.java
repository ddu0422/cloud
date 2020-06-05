package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 해당 Annotation을 생성할 수 있는 위치
// PARAMETER로 지정했으니 메서드 파라미터로 선언된 객체에서만 사용 가능
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// 이 파일은 Annotation 클래스로 지정
// LoginUser라는 이름을 가진 Annotation이 생성
public @interface LoginUser {
}
