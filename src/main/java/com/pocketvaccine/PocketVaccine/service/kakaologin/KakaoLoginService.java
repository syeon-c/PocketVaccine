package com.pocketvaccine.PocketVaccine.service.kakaologin;

import com.pocketvaccine.PocketVaccine.domain.user.dto.KakaoToken;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface KakaoLoginService {
    User signIn();
    User signUp();
    //disconnect;
    KakaoToken getAccessToken(String accessToken);
}
