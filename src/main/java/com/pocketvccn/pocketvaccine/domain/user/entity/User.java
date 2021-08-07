package com.pocketvccn.pocketvaccine.domain.user.entity;

import com.pocketvccn.pocketvaccine.domain.board.entity.Board;
import com.pocketvccn.pocketvaccine.domain.user.type.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userEmail;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;

//    @OneToMany(mappedBy = "user")
//    private List<Board> boards;

}
