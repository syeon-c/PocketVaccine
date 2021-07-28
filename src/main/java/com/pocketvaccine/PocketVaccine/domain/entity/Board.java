package com.pocketvaccine.PocketVaccine.domain.entity;

import com.pocketvaccine.PocketVaccine.domain.type.VaccineType;
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
    private Long boardNo;

    private String userId;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

}




