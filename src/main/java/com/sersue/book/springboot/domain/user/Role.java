package com.sersue.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST","손님"), //권한코드에 항상 ROLE_이 앞에 있어야만 한다.
    USER("ROLE_USER","일반사용자");

    private final String key;
    private final String title;

}
