package com.pocketvaccine.PocketVaccine.controller;

import com.pocketvaccine.PocketVaccine.service.kakaologin.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KakaoLoginController {
    private final KakaoLoginService kakaoLoginService;

}
