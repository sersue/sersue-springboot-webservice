package com.sersue.book.springboot.config.auth; // 시큐리티 관련 클래스

import com.sersue.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화 시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomeOuth2UserService customOuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        http.csrf().disable()
                .headers().frameOptions().disable() //h2-console화면을 사용하기위한 해당 옵션 disable
                .and()
                .authorizeRequests() // URL별 관리를 설정하는 옵션의 시작점  이걸 해야 antMatcher 를 사용할 수 있다.
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()// 해당 url은 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//해당 url은 USER 권한만 가능
                .anyRequest().authenticated()//설정된값들 이외 나머지 url들은 authenticated- login한 사용자들
                .and()
                .logout().logoutSuccessUrl("/")//로그아웃 성공시 "/"
                .and()
                .oauth2Login() //로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() //로그인 성공이후 사용자 정보를 가져올 때의 설정들을 담당
                .userService(customOuth2UserService); // 소셜로그인 성공시 후속 조치를 진행할 userService 인터페이스의 구현체를 등록
        //리소스 서버 (구글 네이버..)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}
