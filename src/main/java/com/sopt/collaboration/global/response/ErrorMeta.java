package com.sopt.collaboration.global.response;

public record ErrorMeta(
        String path,
        long timestamp
) {
    public static ErrorMeta of(String path) {
        return new ErrorMeta(path, System.currentTimeMillis());
    }
}
