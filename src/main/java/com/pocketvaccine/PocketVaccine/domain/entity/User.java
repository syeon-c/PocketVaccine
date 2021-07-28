package com.pocketvaccine.PocketVaccine.domain.entity;

import com.pocketvaccine.PocketVaccine.domain.type.Sex;
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
    private Long id;

    private String user_id;

    private String password;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private int age;

}
