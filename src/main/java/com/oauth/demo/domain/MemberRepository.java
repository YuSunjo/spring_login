package com.oauth.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Member findByEmail(String email);

    Member findByEmailAndPassword(String email, String password);

//    @Query(value = "select * from member where email = ?1", nativeQuery = true)
//    Member login(String email);

}
