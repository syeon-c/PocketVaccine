package com.pocketvaccine.PocketVaccine.service.user;

import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;
import com.pocketvaccine.PocketVaccine.domain.user.dto.UserDto;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public ResultDto<User> join(UserDto userDto) {
        return null;
    }

    @Override
    public ResultDto signIn(String userId, String password) {
        return null;
    }
}