package com.oauth.demo.Service.login;

import com.oauth.demo.Service.login.dto.request.LoginRequest;
import com.oauth.demo.Service.login.dto.request.SignupRequest;
import com.oauth.demo.domain.Member;
import com.oauth.demo.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(SignupRequest request) {
        Member member = Member.signup(request.getEmail(), request.getPassword(), request.getNickname());
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member login(LoginRequest request) {
        return memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
    }
}
