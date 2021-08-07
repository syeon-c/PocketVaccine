package com.pocketvaccine.PocketVaccine.domain.symptom.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board_symptom")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Symptom {
    @EmbeddedId
    private SymptomId symptomId;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long boardId;
//
////    @Enumerated(EnumType.STRING)
//    private SymptomType symptom;

//    @ManyToOne(optional = false)
//    private Board board;

//    @Transient
//    private String ages;
////    @Transient
//    private Long countMusclePain;
////    @Transient
//    private Long countFever;
////    @Transient
//    private Long countChill;
////    @Transient
//    private Long countHeadache;

//    @Builder
//    public Symptom(String ages, Long countMusclePain, Long countFever, Long countChill, Long countHeadache) {
//        this.ages = ages;
//        this.countMusclePain = countMusclePain;
//        this.countFever = countFever;
//        this.countChill = countChill;
//        this.countHeadache = countHeadache;
//    }
}
