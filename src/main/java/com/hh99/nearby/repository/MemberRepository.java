package com.hh99.nearby.repository;


import com.hh99.nearby.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByNickname(String Nickname);

    Optional<Member> findById(Long id);
}
