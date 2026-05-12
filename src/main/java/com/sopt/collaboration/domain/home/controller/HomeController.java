package com.sopt.collaboration.domain.home.controller;

import com.sopt.collaboration.domain.home.service.HomeService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/recommendations")
    public ResponseEntity<ApiResponseBody<RecommendationResponse, Void>> getRecommendations() {
        return ResponseEntity.ok(ApiResponseBody.ok(SuccessCode.OK, homeService.getRecommendations()));
    }
}
