package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.entity.User;
import com.pocketvaccine.PocketVaccine.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {
//    private final UserService userService;
//
//    @PostMapping("/api/users")
//    public CreateUserResponse saveUser(@RequestBody User user) {
//        String id = userService.join(user);
//        return new CreateUserResponse(id);
//    }
//
//    @Data
//    static class CreateUserResponse {
//        private String id;
//
//        public CreateUserResponse(String id) {
//            this.id = id;
//        }
//    }
}