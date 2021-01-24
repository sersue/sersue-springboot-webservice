package com.sersue.book.springboot.config.auth.dto;

import com.sersue.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;
    public SessionUser(User user){
        this.name=getName();
        this.email=getEmail();
        this.picture=getPicture();
    }
}
