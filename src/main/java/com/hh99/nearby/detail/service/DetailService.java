package com.hh99.nearby.detail.service;

import com.hh99.nearby.detail.dto.DetailResponseDto;
import com.hh99.nearby.entity.Challenge;
import com.hh99.nearby.entity.Member;
import com.hh99.nearby.entity.MemberChallenge;
import com.hh99.nearby.repository.ChallengeRepository;
import com.hh99.nearby.repository.MemberChallengeRepository;
import com.hh99.nearby.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DetailService {
    private final ChallengeRepository challengeRepository;
    private final MemberRepository memberRepository;
    private final MemberChallengeRepository memberChallengeRepository;

    @Transactional
    public ResponseEntity<?> detailModal(@PathVariable Long id) {
        Challenge challenge = isPresentChallenge(id);
        if (challenge == null) {
            return ResponseEntity.badRequest().body(Map.of("msg", "잘못된 챌린지 번호"));
        }

        long participatePeople = challenge.getMemberChallengeList().size();

        DetailResponseDto detailResponseDto = DetailResponseDto.builder()
                .title(challenge.getTitle())
                .challengeImg(challenge.getChallengeImg())
                .startDay(challenge.getStartDay())
                .startTime(challenge.getStartTime())
                .targetTime(challenge.getTargetTime())
                .endTime(challenge.getEndTime())
                .limitPeople(challenge.getLimitPeople())
                .participatePeople(participatePeople)
                .content(challenge.getContent())
                .notice(challenge.getNotice())
                .writer(challenge.getWriter().getNickname())
                .level(0+"LV")
                .challengeTag(challenge.getChallengeTag())
                .build();
        return ResponseEntity.ok().body(Map.of("detailModal", detailResponseDto, "msg", "상세모달 조회 완료"));
    }

    @Transactional(readOnly = true)
    public Challenge isPresentChallenge(Long id) {
        Optional<Challenge> optionalChallenge = challengeRepository.findById(id);
        return optionalChallenge.orElse(null);
    }

    //참여하기
    @Transactional
    public ResponseEntity<?> participateChallenge(@PathVariable Long id, @AuthenticationPrincipal UserDetails user) {

        Challenge challenge = isPresentChallenge(id);
        if (challenge == null) {
            return ResponseEntity.badRequest().body(Map.of("msg", "잘못된 챌린지 번호"));
        }
        Optional<Member> member = memberRepository.findByEmail(user.getUsername());

        MemberChallenge memberChallenge = MemberChallenge.builder()
                .challenge(challenge)
                .member(member.get())
                .build();
        memberChallengeRepository.save(memberChallenge);
        return ResponseEntity.ok().body(Map.of("msg", "참여하기 완료"));
    }
    //참여 취소하기
    @Transactional
    public ResponseEntity<?> cancelChallenge(@PathVariable Long id, @AuthenticationPrincipal UserDetails user){
        Challenge challenge = isPresentChallenge(id);
        if (challenge == null) {
            return ResponseEntity.badRequest().body(Map.of("msg", "잘못된 챌린지 번호"));
        }
        Optional<Member> member = memberRepository.findByEmail(user.getUsername());

        if (!challenge.getWriter().getId().equals(member.get().getId())){
            return ResponseEntity.badRequest().body(Map.of("msg","참여하지 않으셨습니다."));
        }
        Optional<MemberChallenge> memberChallenge = memberChallengeRepository.findByMember_IdAndChallenge_Id(id,member.get().getId());
        memberChallengeRepository.delete(memberChallenge.get());
        return ResponseEntity.ok().body(Map.of("msg", "참여하기 취소 완료"));
    }
}

