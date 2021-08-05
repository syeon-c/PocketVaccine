package com.pocketvaccine.PocketVaccine.domain.user.dto;

import lombok.Data;

@Data
public class KakaoToken {

    private String tokenType;

    private String accessToken;

    private String refreshToken;

    private Integer expiresIn;

    private Integer refreshTokenExpiresIn;

    private Long id;

    private Long expiresInMillis;

    private Integer code;

}
