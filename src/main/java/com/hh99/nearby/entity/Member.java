package com.hh99.nearby.entity;

import com.hh99.nearby.mypage.dto.request.MypageRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String password;

    @Column
    private String profileImg;

    //이메일 인증 확인
    @Column(nullable = false)
    private boolean emailCheck;

    @Column
    private Long kakaoId;

    public boolean validatePassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.matches(password, this.password);
    }

    public void update() {
        this.emailCheck = true;
    }

    public void update(MypageRequestDto requestDto){
        this.nickname = requestDto.getNickName();
        this.profileImg= requestDto.getProfileImg();
    }

    public void update(String nickname){this.nickname = nickname;}
}
