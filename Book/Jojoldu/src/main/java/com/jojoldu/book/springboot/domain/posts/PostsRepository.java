package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository가 없어도 된다.
// Entity 클래스는 기본 Repository 없이는 제대로 역할 할 수 없기 때문에 같은 패키지에 둔다.
// 도메인 패키지에서 Entity 클래스와 함께 관리
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
