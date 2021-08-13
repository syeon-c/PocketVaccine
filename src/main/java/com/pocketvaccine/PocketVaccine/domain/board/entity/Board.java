package com.pocketvaccine.PocketVaccine.domain.board.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Symptom> symptoms;

    @Builder
    public Board(Long userId, String title, String content, Date createdAt,
                 Integer vaccineDose, VaccineType vaccineType, List<Symptom> symptoms) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.vaccineDose = vaccineDose;
        this.vaccineType = vaccineType;
        this.symptoms = symptoms;

    }

}




