package com.pocketvaccine.PocketVaccine.domain.user.entity;

import com.pocketvaccine.PocketVaccine.domain.user.type.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Long kakaoId;

    @Setter
    private String userName;

    @Setter
    private String userEmail;

    private String password;

    private String ageRange;

    @Setter
    private String accessToken;

    @Setter
    private String refreshToken;

}
