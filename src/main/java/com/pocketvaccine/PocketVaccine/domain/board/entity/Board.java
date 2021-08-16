package com.pocketvaccine.PocketVaccine.domain.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private LocalDateTime updatedAt;

    private Integer likes;

    private String ageRange;

    private Integer vaccineDose;

    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

    @JsonIgnore
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Symptom> symptoms;

    @Builder
    public Board(User user, String title, String content, Integer vaccineDose, VaccineType vaccineType, Integer likes, String ageRange, List<Symptom> symptoms) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.vaccineDose = vaccineDose;
        this.vaccineType = vaccineType;
        this.likes = likes;
        this.ageRange = ageRange;
        this.symptoms = symptoms;
    }

}




