package com.oauth.demo.Service.login.dto.request;

import com.oauth.demo.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LoginRequest {

    private String email;

    private String password;

}
