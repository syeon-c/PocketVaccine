package com.pocketvaccine.PocketVaccine.domain.symptom.entity;

import com.pocketvaccine.PocketVaccine.domain.symptom.type.SymptomType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class SymptomId implements Serializable {
    private Long boardId;

    @Column(name = "symptom")
    @Enumerated(EnumType.STRING)
    private SymptomType symptom;

    @Builder
    public SymptomId(Long boardId, SymptomType symptom) {
        this.boardId = boardId;
        this.symptom = symptom;
    }
}
