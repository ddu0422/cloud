package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Lombok Annotation
@NoArgsConstructor
@Getter
// JPA Annotation
// 테이블과 링크될 클래스
// 기본값으로 클래스의 camelCase 이름을 under_score 네이밍으로 테이블 이름을 매칭
@Entity
public class Posts {

    // 해당 테이블의 PK 필드
    @Id
    // PK 규칙을 생성
    // Hibernate 5.0 이상에선 Auto 설정 시 Table 전략이므로 MySQL을 사용하니 IDENTITY를 습관화하자
    // https://www.jojoldu.tistory.com/295
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Long으로 설정하는 이유
    // FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 두어야 하는 상황 발생
    // 인덱스에 좋지 않음
    // 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일 발생
    private Long id;

    // 기본 값 외에 추가 변경이 필요한 옵션이 있으면 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 사용 이유 : 같은 타입일 경우 값이 잘못들어 왔을 때 찾기가 힘들다.
    // 빌터 패턴을 이용하여 올바른 값을 대입하자.
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
