package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.domain.user.type.Gender;
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

    private String age_range;

    protected UserDto(User entity) {
        this.userId = entity.getUserId();
        this.kakaoId = entity.getKakaoId();
        this.userName = entity.getUserName();
        this.userEmail = entity.getUserEmail();
        this.age_range = entity.getAge_range();
    }

    public static UserDto ofEntity(User entity) {
        return new UserDto(entity);
    }
}
