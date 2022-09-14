package com.hh99.nearby.repository;


import com.hh99.nearby.entity.Challenge;
import com.hh99.nearby.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
