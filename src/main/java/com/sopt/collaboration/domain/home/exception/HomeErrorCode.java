package com.sopt.collaboration.domain.home.exception;

import com.sopt.collaboration.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HomeErrorCode implements ErrorCode {

    // 400 BAD REQUEST
    INVALID_EXPAND_PARAMETER(400, "HOM_400_001", "expand 파라미터 값이 유효하지 않습니다."),

    // 404 NOT FOUND
    NO_ACTIVE_PROMOTION(404, "HOM_404_001", "현재 활성화된 프로모션이 없습니다.");

    private final int status;
    private final String code;
    private final String message;
}