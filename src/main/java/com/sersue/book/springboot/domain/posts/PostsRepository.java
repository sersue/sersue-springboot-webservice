package com.sersue.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts,Long> {
    //인터페이스 생성후, JpaRepository<Entity 클래스,PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 실행

}
