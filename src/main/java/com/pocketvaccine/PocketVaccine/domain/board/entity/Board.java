package com.pocketvaccine.PocketVaccine.domain.board.entity;


import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


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

    private boolean musclePain;

    private boolean fever;

    private boolean chill;

    private boolean nausea;

    private boolean diarrhea;

    private boolean headache;

    private boolean throatPain;

    private boolean fatigue;

    private boolean allergy;

    private boolean etc;

    @Builder
    public Board(User user, String title, String content, Integer likes, String ageRange, Integer vaccineDose, VaccineType vaccineType,
                 boolean musclePain, boolean fever, boolean chill, boolean nausea, boolean diarrhea, boolean headache, boolean throatPain, boolean fatigue, boolean allergy, boolean etc) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.likes = likes;
        this.ageRange = ageRange;
        this.vaccineDose = vaccineDose;
        this.vaccineType = vaccineType;
        this.musclePain = musclePain;
        this.fever = fever;
        this.chill = chill;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.headache = headache;
        this.throatPain = throatPain;
        this.fatigue = fatigue;
        this.allergy = allergy;
        this.etc = etc;
    }
}




