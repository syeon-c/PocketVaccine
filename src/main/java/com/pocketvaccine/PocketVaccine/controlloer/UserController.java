package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.dto.UserDto;
import com.pocketvaccine.PocketVaccine.domain.entity.User;
import com.pocketvaccine.PocketVaccine.domain.type.Sex;
import com.pocketvaccine.PocketVaccine.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserDto userDto) {
        Long id = userDto.getId();
        String userId = userDto.getUserId();
        String password = userDto.getPassword();
        Sex sex = userDto.getSex();

        ResponseEntity<UserDto> userEntity = userService.join(userDto);

        return userEntity;
    }

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody UserDto userDto) {
        String userId = userDto.getUserId();
        String password = userDto.getPassword();

        ResponseEntity<UserDto> userEntity = userService.signIn(userId, password);
        return userEntity;
    }
}
