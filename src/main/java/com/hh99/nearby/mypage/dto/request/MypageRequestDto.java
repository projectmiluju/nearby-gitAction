package com.hh99.nearby.mypage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class MypageRequestDto {

    private String nickName;

    private String profileImg;
}
