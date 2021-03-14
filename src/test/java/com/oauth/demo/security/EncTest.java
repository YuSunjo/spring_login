package com.oauth.demo.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {

    @Test
    void 해쉬_암호화() {
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println("encPassword = " + encPassword);
    }

}
