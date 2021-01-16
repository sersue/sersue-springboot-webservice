package com.sersue.book.springboot.web.dto;
/*
[package] 롬복 기능 (getter,생성자) 자동생성 test
 assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드
 1.@Getter로 get 메소드가 잘 실행 되었는지
 2.@RequiredArgsConstructor로 생성자가 자동으로 생성되는지
*/
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name ="test";
        int amount =100;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
