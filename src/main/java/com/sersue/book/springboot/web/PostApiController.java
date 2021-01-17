package com.sersue.book.springboot.web;

import com.sersue.book.springboot.service.posts.PostsService;
import com.sersue.book.springboot.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
 public Long save(@RequestBody PostSaveRequestDto requestDto){
   return postsService.save(requestDto); //request 받아서 postservice에 저장
  }
}
