package com.sersue.book.springboot.config.auth;

import com.sersue.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver { //HandlerMethodArgumentResolver 는 조건에 맞는 경우 메소드가 있다면 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있다.

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter){
        boolean isLoginUserAnnoation = parameter.getParameterAnnotation(LoginUser.class)!=null; // 파라미터에 @LoginUser annotation이 붙어있고
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); // 파라미터 클래스 타입이 SessionUser인 경우
        return isLoginUserAnnoation && isUserClass; //true를 반환
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws  Exception{
        return httpSession.getAttribute("user");
    }
}
