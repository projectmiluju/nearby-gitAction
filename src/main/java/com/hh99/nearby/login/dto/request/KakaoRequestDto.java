package com.hh99.nearby.login.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@AllArgsConstructor
@Getter
public class KakaoRequestDto {

    private Long kakaoid;
    private String nickname;
    private String profileImg;


}
