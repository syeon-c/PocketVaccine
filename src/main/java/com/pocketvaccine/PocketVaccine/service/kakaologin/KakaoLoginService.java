package com.pocketvaccine.PocketVaccine.service.kakaologin;

import com.pocketvaccine.PocketVaccine.domain.user.dto.KakaoToken;
import com.pocketvaccine.PocketVaccine.domain.user.dto.KakaoUserInfoDto;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;

public interface KakaoLoginService {

    User signIn(Long kakaoId);

    User signUp(String code);

    KakaoUserInfoDto getKakaoUserInfo(String accessToken);

    KakaoToken generateToken(String code);

    KakaoToken refreshToken(String refreshToken);

    KakaoToken getKakaoTokenInfo(String accessToken);
}
