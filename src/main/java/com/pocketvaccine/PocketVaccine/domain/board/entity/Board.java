package com.pocketvaccine.PocketVaccine.domain.board.entity;

import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date updatedAt;

    private Integer likes;

    private Integer vaccineDose;

    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

    @Builder
    public Board(User user, String title, String content, Integer vaccineDose, VaccineType vaccineType) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDate.now();
        this.vaccineDose = vaccineDose;
        this.vaccineType = vaccineType;
    }

}




