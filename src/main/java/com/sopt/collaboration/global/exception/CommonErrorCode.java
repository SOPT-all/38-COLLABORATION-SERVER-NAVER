package com.sopt.collaboration.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    // 400 BAD REQUEST
    INVALID_MAPPING_PARAMETER(400, "COM_400_001", "매핑할 수 없는 값입니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "COM_500_001", "서버 내부 오류가 발생했습니다.");

    private final int status;
    private final String code;
    private final String message;
}