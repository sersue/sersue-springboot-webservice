package com.sersue.book.springboot.domain.posts;
//[Posts 클래스]
// 실제 DB의 테이블과 매칭될 클래스 (= Entity 클래스)
// JPA 를 사용하면 DB에 작업할 경우 실제 쿼리를 날리기보다, Entity 클래스의 수정을 통해 작업
import com.sersue.book.springboot.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
[JPA annotation]
* @Entity : 테이블과 링크될 클래스임을 나타냅니다.
  @Id : 해당 테이블의 PK필드를 나타냅니다.
  @GeneratedValue : PK의 생성규칙을 나타냅니다
  @Column : 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
          : 기본값 이외에 추가로 변경이 필요한 옵션이 있으면 사용.
          : 여기선 사이즈를 500으로 늘리고 싶거나,타입을 TEXT로 바꾸고 싶을 때 */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder // 빌더 패턴 - setter,여러개의 생성자를 사용하지 않고 객체를 깔끔하게 만들 수 있는 방법 한번에 build()
    public Posts(String title,String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

}
