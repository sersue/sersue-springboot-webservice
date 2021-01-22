package com.sersue.book.springboot.web;
//페이지와 관련된 모든 컨트롤러
import com.sersue.book.springboot.service.posts.PostsService;
import com.sersue.book.springboot.web.dto.PostsListResponseDto;
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
    public String index(Model model){ //Model을 이용해 데이터를 가져오고 view에 데이터를 넘겨 적절한 view를 생성하는 역할.
        model.addAttribute("posts",postsService.findAllDesc()); //posts,postservice.findalldesc() key,value쌍으로 전달
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
