package com.oauth.demo.controller;

import com.oauth.demo.controller.security.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    //세션 접근할 때
    @GetMapping("/")
    public String index(@AuthenticationPrincipal PrincipalDetail principalDetail) {
        return "index";
    }

}
