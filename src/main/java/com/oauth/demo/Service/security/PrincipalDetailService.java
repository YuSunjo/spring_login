package com.oauth.demo.Service.security;

import com.oauth.demo.controller.security.PrincipalDetail;
import com.oauth.demo.domain.Member;
import com.oauth.demo.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    //스프링이 로그인 요청을 가로챌 때, username, password 변수2개를 가로채는데
    //패스워드 부분 처리는 알아서
    //해당 username이 db에 있는지만 확인해주면됨
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다." + username);
                });
        return new PrincipalDetail(member);  // 시큐리티 세션에 유저 정보가 저장이 됨
    }
}
