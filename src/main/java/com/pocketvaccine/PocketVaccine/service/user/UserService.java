package com.pocketvaccine.PocketVaccine.service.user;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;
import com.pocketvaccine.PocketVaccine.domain.user.dto.UserDto;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findById(Long userId);

    //회원가입
    ResultDto<User> join(UserDto userDto);

    //로그인
    ResultDto signIn(String userId, String password);

}