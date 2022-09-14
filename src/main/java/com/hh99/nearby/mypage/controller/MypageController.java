package com.hh99.nearby.mypage.controller;

import com.hh99.nearby.mypage.dto.request.MypageRequestDto;
import com.hh99.nearby.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MypageController {

    private final MypageService mypageService;

   // 마이페이지
    @GetMapping("/api/member")
    public ResponseEntity<?> myPage(@AuthenticationPrincipal UserDetails user){
        return mypageService.myPage(user);
    }

    //프로필 수정
    @PutMapping("/api/member")
    public ResponseEntity<?> memberUpdate(@RequestBody MypageRequestDto requestDto, @AuthenticationPrincipal UserDetails user){
        return mypageService.memberUpdate(requestDto,user);
    }
}
