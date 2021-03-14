package com.oauth.demo.controller.login;

import com.oauth.demo.Service.login.LoginService;
import com.oauth.demo.Service.login.dto.request.LoginRequest;
import com.oauth.demo.Service.login.dto.request.SignupRequest;
import com.oauth.demo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/api/user/signup")
    public HttpStatus signUp(@RequestBody SignupRequest request) {
        loginService.signup(request);
        return HttpStatus.OK;
    }

    @PostMapping("/api/user/login")
    public HttpStatus login(@RequestBody LoginRequest request, HttpSession session) {
        Member member = loginService.login(request);
        if (member != null) {
            session.setAttribute("member", member);
        }
        return HttpStatus.OK;
    }

}
