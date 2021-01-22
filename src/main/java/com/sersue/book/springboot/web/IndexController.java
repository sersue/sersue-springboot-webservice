package com.sersue.book.springboot.web;
//페이지와 관련된 모든 컨트롤러
import com.sersue.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){ //Model을 이용해 데이터를 가져오고 view에 데이터를 넘겨 적절한 view를 생성하는 역할.
        model.addAttribute("posts",postsService.findAllDesc()); //posts,postservice.findalldesc() key,value쌍으로 전달
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
