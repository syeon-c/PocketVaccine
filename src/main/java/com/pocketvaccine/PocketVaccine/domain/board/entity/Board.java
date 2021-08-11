package com.pocketvaccine.PocketVaccine.domain.board.entity;

import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date updatedAt;

    private Integer likes;

    private Integer vaccineDose;

    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

    @Builder
    public Board(Long userId, String title, String content, Date createdAt, Integer vaccineDose, VaccineType vaccineType) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.vaccineDose = vaccineDose;
        this.vaccineType = vaccineType;
    }

}




