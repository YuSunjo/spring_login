package com.oauth.demo.Service.login.dto.response;

import com.oauth.demo.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponse {

    private final Long id;

    private final String email;

    private final String nickname;

    public static LoginResponse of(Member member) {
        return new LoginResponse(member.getId(), member.getEmail(), member.getUsername());
    }

}
