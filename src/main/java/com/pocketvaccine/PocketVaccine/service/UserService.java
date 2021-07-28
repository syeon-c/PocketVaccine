package com.pocketvaccine.PocketVaccine.service;

import com.pocketvaccine.PocketVaccine.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //회원가입
    public ResponseEntity<UserDto> join(UserDto userDto);

    //로그인
    public ResponseEntity<UserDto> signIn(String userId, String password);
}
