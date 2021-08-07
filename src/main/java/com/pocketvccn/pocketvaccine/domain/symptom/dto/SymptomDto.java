package com.pocketvccn.pocketvaccine.domain.symptom.dto;

import com.pocketvccn.pocketvaccine.domain.board.dto.BoardDto;
import com.pocketvccn.pocketvaccine.domain.board.entity.Board;
import com.pocketvccn.pocketvaccine.domain.symptom.entity.Symptom;
import com.pocketvccn.pocketvaccine.domain.symptom.entity.SymptomId;
import com.pocketvccn.pocketvaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvccn.pocketvaccine.domain.symptom.type.SymptomType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

//@Entity
//@ToString
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class SymptomDto {
//    private String ages;
//
//    private Long countMusclePain;
//
//    private Long countFever;
//
//    private Long countChill;
//
//    private Long countHeadache;
//
//    protected SymptomDto(SymptomMapping entity) {
//        this.ages = entity.getAges();
//        this.countMusclePain = entity.getCountMusclePain();
//        this.countFever = entity.getCountFever();
//        this.countChill = entity.getCountChill();
//        this.countHeadache = entity.getCountHeadache();
//    }
//
//    public static SymptomDto ofEntity(SymptomMapping entity) {
//        return new SymptomDto(entity);
//    }
//
//    public static List<SymptomDto> ofEntities(List<SymptomMapping> entities) {
//        return entities.stream().map(SymptomDto::ofEntity).collect(Collectors.toList());
//    }
//}
