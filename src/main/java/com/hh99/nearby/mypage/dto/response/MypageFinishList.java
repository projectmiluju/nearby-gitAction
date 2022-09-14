package com.hh99.nearby.mypage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@AllArgsConstructor
@Getter
public class MypageFinishList {

    private String title; //제목

    private Date startTime; //시작 시간

    private Long tagetTime; // 진행시간

    private Long endtime; // 종료시간
}
