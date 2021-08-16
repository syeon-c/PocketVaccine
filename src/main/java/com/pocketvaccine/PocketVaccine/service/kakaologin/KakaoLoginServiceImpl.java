package com.pocketvaccine.PocketVaccine.service.kakaologin;

import com.pocketvaccine.PocketVaccine.domain.user.dto.KakaoToken;
import com.pocketvaccine.PocketVaccine.domain.user.dto.KakaoUserInfoDto;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.repository.UserRepository;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements KakaoLoginService {

    private final RestTemplate restTemplate;

    private final UserRepository userRepository;

    @Value("${kakao.auth-token-uri}")
    private String kokaoAuthTokenUri;

    @Value("${kakao.rest-api-key}")
    private String kakaoRestApiKey;

    @Value("${kakao.redirect-uri}")
    private String kakaoRedirectUri;

    @Value("${kakao.user-me-uri}")
    private String kakaoUserMeUri;

    @Value("${kakao.access-token-info-uri}")
    private String kakaoAccessTokenInfoUri;


    @Override
    public User signIn(Long kakaoId) {
        Optional<User> user = userRepository.findByKakaoId(kakaoId);
        String access_token = null;
        String refresh_token = null;

        if(user.isPresent()) {
            access_token = user.get().getAccessToken();
            refresh_token = user.get().getRefreshToken();

            try {
                KakaoToken kakaoToken = getKakaoTokenInfo(access_token);
                // KakaoToken 만료시 refreshToken으로 재발행
                if(kakaoToken.getCode() != 200) {
                    kakaoToken = refreshToken(refresh_token);
                    //
                    if (kakaoToken.getCode() == 200) {
                        user.get().setAccessToken(kakaoToken.getAccessToken());
                        user.get().setRefreshToken(kakaoToken.getRefreshToken());
                        userRepository.save(user.get());
                    }
                }
                return user.get();
            } catch (HttpClientErrorException e) {
                return null;
            }
        }
        // Token 만료
        return null;
    }

    @Override
    @Transactional
    public User signUp(String code) throws HttpClientErrorException {
        User user = null;
        KakaoToken token = generateToken(code);
        String accessToken = token.getAccessToken();
        KakaoUserInfoDto kakaoUserInfoDto = getKakaoUserInfo(accessToken);

        Optional<User> userOptional = userRepository.findByKakaoId(kakaoUserInfoDto.getId());
        if(userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            user = user.builder().kakaoId(kakaoUserInfoDto.getId()).build();
        }

        // 변경된 정보 업데이트
        user.setUserEmail(kakaoUserInfoDto.getKakaoAccount().getAccountEmail());
        user.setNickname(kakaoUserInfoDto.getKakaoProperty().getNickName());
        user.setAccessToken(accessToken);
        user.setRefreshToken(token.getRefreshToken());
        userRepository.save(user);

        return user;
    }

    @Override
    public KakaoUserInfoDto getKakaoUserInfo(String accessToken) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + accessToken);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        try {
            ResponseEntity<KakaoUserInfoDto> response = restTemplate.exchange(kakaoUserMeUri,
                    HttpMethod.GET, request, KakaoUserInfoDto.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public KakaoToken generateToken(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", kakaoRestApiKey);
        map.add("redirect_uri", kakaoRedirectUri);
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        try {
            KakaoToken response = restTemplate
                    .postForObject(kokaoAuthTokenUri, request, KakaoToken.class,
                            request);
            return response;
        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public KakaoToken refreshToken(String refreshToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", kakaoRestApiKey);
        map.add("refresh_token", refreshToken);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        try {
            KakaoToken response = restTemplate
                    .postForObject(kokaoAuthTokenUri, request, KakaoToken.class,
                            request);
            response.setCode(200);
            return response;
        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public KakaoToken getKakaoTokenInfo(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + accessToken);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        try {
            ResponseEntity<KakaoToken> response = restTemplate.exchange(kakaoAccessTokenInfoUri,
                    HttpMethod.GET, request, KakaoToken.class);

            if(response.getStatusCode() == HttpStatus.OK) {
                response.getBody().setCode(200);
            }
            return response.getBody();
        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }
}
