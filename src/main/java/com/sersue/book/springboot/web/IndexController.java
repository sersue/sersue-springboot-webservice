package com.sersue.book.springboot.web;
//페이지와 관련된 모든 컨트롤러
import com.sersue.book.springboot.config.auth.LoginUser;
import com.sersue.book.springboot.config.auth.dto.SessionUser;
import com.sersue.book.springboot.service.posts.PostsService;

import com.sersue.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
            System.out.println(user.getEmail());
        }
        return "index";
    }
    //SessionUser user = (SessionUser) httpSession.getAttribute("user");  로그인 성공시 세션에 SessionUser저장 해 둠

//1. Model을 이용해 데이터를 가져오고 view에 데이터를 넘겨 적절한 view를 생성하는 역할.
//1. posts,postservice.findalldesc() key,value쌍으로 전달
//1-1.(코드 개선 )@LogiUser annotaion을 생성하여 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있게 되었다.

    //session에 user 있으면


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
