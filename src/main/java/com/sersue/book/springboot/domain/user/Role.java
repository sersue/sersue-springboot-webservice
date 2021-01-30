package com.sersue.book.springboot.domain.user;
//enum은 final 선언 같은 것 -> 다른 점은 final 선언은 다른 상수값이 들어와도 알수 없지만 enum은 미리 알수 있어서 오류 방지 할 수 있다.
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
