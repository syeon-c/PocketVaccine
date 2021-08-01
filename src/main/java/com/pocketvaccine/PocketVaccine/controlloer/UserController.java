package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
}
