package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoUserInfoDto {

    private Long id;

    private KakaoProperty kakaoProperty;

    //??
    @JsonProperty(value = "kakao_account")
    private KakaoAccount kakaoAccount;
}
