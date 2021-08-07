package com.pocketvccn.pocketvaccine.controller;

import com.pocketvccn.pocketvaccine.domain.user.entity.User;
import com.pocketvccn.pocketvaccine.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/joinUs.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity join(@RequestBody User user) {
        log.info("userId = {}, password = {}", user.getUserId(), user.getPassword());
        if(userService.join(user).equals("Success")) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity signIn(@RequestBody User user){
        log.info("userId = {}, password = {}", user.getUserId(), user.getPassword());
        if(userService.signIn(user.getUserId(), user.getPassword()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
