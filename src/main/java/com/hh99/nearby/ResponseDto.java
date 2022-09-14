package com.hh99.nearby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@Getter
public class ResponseDto<T> {

    private T data;
    private String message;

    public static <T> ResponseEntity<?> success(T output, String code, String message) {
//        return new ResponseDto<>(true, output, new Error(code, message));
        ResponseEntity.ok().body("로그인이 필요합니다.");
        ResponseDto.success(null,"200","굿");
        return ResponseEntity.ok().body("로그인이 필요합니다.");
    }

    public static <T> ResponseDto<T> fail(String code, String message) {
        return new ResponseDto<>(null, null);
    }

}