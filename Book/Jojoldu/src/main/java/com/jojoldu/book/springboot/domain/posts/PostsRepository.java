package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// @Repository가 없어도 된다.
// Entity 클래스는 기본 Repository 없이는 제대로 역할 할 수 없기 때문에 같은 패키지에 둔다.
// 도메인 패키지에서 Entity 클래스와 함께 관리
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // Query DSL
    /*
        1. 타입 안정성이 보장
            - 단순 문자열로 쿼리를 생성 x, 메서드를 기반으로 쿼리를 생성
            - 오타나 존재하지 앟는 컬럼명을 명시할 경우 IDE에서 자동으로 검출
            - Jooq에서도 지원, MyBatis는 미지원
        2. 국내 많은 회사에서 사용
        3. 레퍼런스가 많다.
     */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
