package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.repository.UserRepository;
import com.pocketvaccine.PocketVaccine.service.kakaologin.KakaoLoginService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Controller
@RequestMapping("/api/kakaologin")
@RequiredArgsConstructor
public class UserController {

    final KakaoLoginService loginService;

    @GetMapping
    public String main() {
        return "index";
    }

    @GetMapping("login")
    public String login(
            @RequestParam String code
            , @CookieValue(value = "kakaoId", required = false) Cookie cookie
            , Model model
            , HttpServletResponse response) {

        Long kakaoId = null;
        User user = null;

        if (cookie != null) {
            kakaoId = Long.valueOf(cookie.getValue());
            System.out.println("kakaoId : " + kakaoId);

        }

        if (kakaoId == null) {
            try {
                user = loginService.signUp(code);
                Cookie cookieKakaoId = new Cookie("kakaoId", user.getKakaoId().toString());
                cookieKakaoId.setMaxAge(60);
                response.addCookie(cookieKakaoId);
            } catch (HttpClientErrorException e) {
                log.error(e.getMessage());
                return "index";
            }
        } else {
            user = loginService.signIn(kakaoId);
            if (user == null) {
                //토큰이 전부 만료가 되었다 !!!
                Cookie cookieKakaoId = new Cookie("kakaoId", "");
                cookieKakaoId.setMaxAge(0);
                response.addCookie(cookieKakaoId);
                return "index";
            }
        }
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpServletResponse response) {
        Cookie cookieKakaoId = new Cookie("kakaoId", "");
        cookieKakaoId.setMaxAge(0);
        response.addCookie(cookieKakaoId);
        return "logout";
    }

}