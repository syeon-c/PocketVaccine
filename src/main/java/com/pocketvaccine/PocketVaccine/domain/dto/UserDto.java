package com.pocketvaccine.PocketVaccine.domain.dto;

import com.pocketvaccine.PocketVaccine.domain.entity.User;
import com.pocketvaccine.PocketVaccine.domain.type.Sex;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDto {

    private Long id;

    private String userId;

    private String password;

    private Sex sex;

    private int age;

    protected UserDto(User entity) {
        this.id = entity.getId();
        this.userId = entity.getUser_id();
        this.password = entity.getPassword();
        this.sex = entity.getSex();
        this.age = entity.getAge();
    }

    public static UserDto ofEntity(User entity) {
        return new UserDto(entity);
    }
}
