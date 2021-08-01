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

    private String userEmail;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

}
