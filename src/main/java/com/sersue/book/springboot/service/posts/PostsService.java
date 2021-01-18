package com.sersue.book.springboot.service.posts;
//[package:service]
/*
Spring 웹 계층
1.Web Layer : 컨트롤러, JSP등의 뷰 템플릿 영역 / 외부 요청과 응답
2.Service Layer : 일반적으로 controller와 Dao의 중간 영역
3.Repository Layer :데이터베이스에 접근하는 영역=dao (data access object)
4.Dtos (data transfer object): 계층간에 데이터 교환을 위한 객체 (ex. 뷰 템플릿에서 사용될 객체, 결과로 넘겨준 객체)
5.DomainModel : 개발대상을 공유할 수 있도록 단순화 시킨 것 --> 비지니스 처리 담당!!!
*/

import com.sersue.book.springboot.domain.posts.Posts;
import com.sersue.book.springboot.domain.posts.PostsRepository;
import com.sersue.book.springboot.web.dto.PostSaveRequestDto;
import com.sersue.book.springboot.web.dto.PostsResponseDto;
import com.sersue.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
* @RequiredArgsConstructor : final이 선언된 모든 필드에 대해 생성자를 생성해 줍니다. -> @Autowired 보다 좋은 객체 주입 받는 방법! = 생성자로 주입받기.
   주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용되곤 합니다.*/
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}
