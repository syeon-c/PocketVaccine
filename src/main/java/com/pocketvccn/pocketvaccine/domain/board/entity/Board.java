package com.pocketvccn.pocketvaccine.domain.board.entity;

import com.pocketvccn.pocketvaccine.domain.board.type.VaccineType;
import com.pocketvccn.pocketvaccine.domain.symptom.entity.Symptom;
import com.pocketvccn.pocketvaccine.domain.user.entity.User;
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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long userId;

    private String title;

    private String content;

    private int vaccineNum;

    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

//    @ManyToOne(optional = false)
//    private User user;
//
//    @OneToMany(mappedBy = "board")
//    private List<Symptom> symptoms;

    @Builder
    public Board(Long userId, String title, String content, int vaccineNum, VaccineType vaccineType) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.vaccineNum = vaccineNum;
        this.vaccineType = vaccineType;
    }
}
