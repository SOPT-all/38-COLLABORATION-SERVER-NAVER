package com.sopt.collaboration.global.exception;

import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.ErrorMeta;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponseBody<Void, ErrorMeta>> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpServletRequest request) {
        System.err.println("HttpMessageNotReadableException: " + ex.getMessage());

        Throwable rootCause = ex;
        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }

        if (rootCause instanceof BusinessException businessException) {
            ErrorCode errorCode = businessException.getErrorCode();
            return ResponseEntity
                    .status(errorCode.getStatus())
                    .body(ApiResponseBody.onFailure(errorCode, ErrorMeta.of(request.getRequestURI())));
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseBody.onFailure(CommonErrorCode.INVALID_MAPPING_PARAMETER, null));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponseBody<Void, ErrorMeta>> handleBusinessException(
            BusinessException e, HttpServletRequest request) {
        ErrorCode errorCode = e.getErrorCode();

        System.err.println("===== HANDLED BUSINESS EXCEPTION =====");
        System.err.printf("[errorCode=%s] %s%n", errorCode.getCode(), e.getMessage());
        System.err.println("======================================");

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponseBody.onFailure(errorCode, ErrorMeta.of(request.getRequestURI())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseBody<Void, ErrorMeta>> handleException(
            Exception e, HttpServletRequest request) {
        System.err.println("===== UNHANDLED EXCEPTION =====");
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.err.println("===============================");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponseBody.onFailure(CommonErrorCode.INTERNAL_SERVER_ERROR, e.getMessage(), ErrorMeta.of(request.getRequestURI())));
    }
}