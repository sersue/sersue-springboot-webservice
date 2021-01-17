package com.sersue.book.springboot.domain.posts;
//[save,findall 기능 테스트]

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //단위테스트 끝날때마다 수행되는 메소드 지정 (다음 테스트를 위해 데이터 침범 막기위해 deleteAll())
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        //given
        String title="테스트 게시글";
        String content="테스트 본문";

        //[postRepository.save] = 테이블 Posts에 insert/update쿼리를 실행한다.
        //id값이 있으면update, 없으면inset 쿼리가 실행된다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("msr56501354@gmail.com")
                .build());

        //when
        // [메소드 findAll() ]테이블에 있는 데이터 조회해오는 메소드
        List<Posts> postsList =postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
