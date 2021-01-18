package com.sersue.book.springboot.web;

import com.sersue.book.springboot.service.posts.PostsService;
import com.sersue.book.springboot.web.dto.PostSaveRequestDto;
import com.sersue.book.springboot.web.dto.PostsResponseDto;
import com.sersue.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    //post 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postsService.save(requestDto); //request 받아서 postservice에 저장
    }

    //수정,조회
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}