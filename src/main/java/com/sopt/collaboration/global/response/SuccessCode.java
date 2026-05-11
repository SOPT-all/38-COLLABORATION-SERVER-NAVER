package com.sopt.collaboration.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {

    OK(HttpStatus.OK, "요청이 성공했습니다."),
    CREATED(HttpStatus.CREATED, "생성이 성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getStatus() {
        return httpStatus.value();
    }
}
