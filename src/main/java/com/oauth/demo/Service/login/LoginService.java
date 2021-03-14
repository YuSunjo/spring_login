package com.oauth.demo.Service.login;

import com.oauth.demo.Service.login.dto.request.LoginRequest;
import com.oauth.demo.Service.login.dto.request.SignupRequest;
import com.oauth.demo.domain.Member;
import com.oauth.demo.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void signup(SignupRequest request) {
        String rawPassword = request.getPassword();
        String encPassword = encoder.encode(rawPassword);
        Member member = Member.signup(request.getEmail(), encPassword, request.getNickname());
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member login(LoginRequest request) {
        return memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
    }
}
