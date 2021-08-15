package com.pocketvaccine.PocketVaccine.domain.symptom.dto;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomId;
import lombok.*;


import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SymptomDto {
    private SymptomId symptomId;

    protected SymptomDto(Symptom entity) {
        this.symptomId = entity.getSymptomId();
    }

    public static SymptomDto ofEntity(Symptom entity) {
        return new SymptomDto(entity);
    }

    public static List<SymptomDto> ofEntities(List<Symptom> entities) {
        return entities.stream().map(SymptomDto::ofEntity).collect(Collectors.toList());
    }
}
