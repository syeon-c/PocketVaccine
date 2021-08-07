package com.pocketvaccine.PocketVaccine.domain.symptom.entity;

import com.pocketvaccine.PocketVaccine.domain.symptom.type.SymptomType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Embeddable
public class SymptomId implements Serializable {
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "symptom")
    @Enumerated(EnumType.STRING)
    private SymptomType symptom;
}
