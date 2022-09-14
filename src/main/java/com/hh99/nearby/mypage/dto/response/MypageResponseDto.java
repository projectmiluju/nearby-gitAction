package com.hh99.nearby.mypage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class MypageResponseDto {

    private String nickname; //닉네임

    private String email; //이메일

    private String profileImg; //프로필 이미지

    private int level; //레벨

    private int rank; //등수

    private String totalTime; //사용시간
    
    List<MypageChallengeList> challengeLists; //도전중인 첼린지 리스트
    
    List<MypageFinishList> finishLists; //완료한 첼린지 리스트

}
