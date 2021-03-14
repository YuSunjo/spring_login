package com.oauth.demo.Service.login.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SignupRequest {

    private String email;

    private String password;

    private String nickname;

}
