package com.pocketvaccine.PocketVaccine.domain.board.entity;

import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long userId;

    private String title;

    private String content;

    private Integer vaccineDose;

    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

    @Builder
    public Board(Long userId, String title, String content, Integer vaccineDose, VaccineType vaccineType) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.vaccineDose = vaccineDose;
        this.vaccineType = vaccineType;
    }

}




