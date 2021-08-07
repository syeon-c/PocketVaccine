package com.pocketvccn.pocketvaccine.service.user;

import com.pocketvccn.pocketvaccine.domain.user.entity.User;
import com.pocketvccn.pocketvaccine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    public String join(User user) {
        userRepository.save(User.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .gender(user.getGender())
                .age(user.getAge())
                .build());

        return "Success";

    }

    //로그인
    public String signIn(Long userId, String password){
        Optional<User> user = userRepository.findByUserId(userId);
        log.info("db password = {}, input password = {}", user.get().getPassword(), password);
        if(user.get().getPassword().equals(password)) {
            return "Success";
        }
        return "Failed";
    }

}
