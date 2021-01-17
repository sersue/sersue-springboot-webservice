package com.sersue.book.springboot.web.dto;
//[package:dto]
//dto : 계층간에 데이터 교환을 위한 객체 (dtos는 영역)
import lombok.Getter;
import lombok.RequiredArgsConstructor;


/*
* Getter:선언된 모든 필드의 get 메소드 생성
* RequiredArgsConstructor : 선언된 모든 final 필드가 포함된 생성자를 생성
* */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
