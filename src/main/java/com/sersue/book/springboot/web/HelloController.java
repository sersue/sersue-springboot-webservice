package com.sersue.book.springboot.web;
//[Package]
// web package : 컨트롤러와 관련된 클래스들

import com.sersue.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//[annotation]
//@RestController : 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
//@GetMapping("/"): HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어줌
//@RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 , 여기서는 외부에서 name이란이름으로 넘긴 파라미터 메소드를 name(String name)으로 저장
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount")int amount){
        return new HelloResponseDto(name,amount);
    }
}
