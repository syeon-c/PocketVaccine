package com.pocketvaccine.PocketVaccine.domain.symptom.entity;

import com.fasterxml.jackson.annotation.*;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.SymptomType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "symptom")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Symptom {

    @EmbeddedId
    private SymptomId symptomId;

    @JsonIgnore
    @MapsId("boardId")
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

}
