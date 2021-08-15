package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDto {

    private Long userId;

    private Long kakaoId;

    private String userName;

    private String userEmail;

    private String password;

    private String ageRange;

    protected UserDto(User entity) {
        this.userId = entity.getUserId();
        this.kakaoId = entity.getKakaoId();
        this.userName = entity.getUserName();
        this.userEmail = entity.getUserEmail();
        this.ageRange = entity.getAgeRange();
    }

    public static UserDto ofEntity(User entity) {
        return new UserDto(entity);
    }
}
