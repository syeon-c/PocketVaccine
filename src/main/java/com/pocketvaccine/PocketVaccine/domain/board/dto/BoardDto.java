package com.pocketvaccine.PocketVaccine.domain.board.dto;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.entity.BoardLike;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDto {

    private Long boardId;

    private Long userId;

    private String nickname;

    private String ageRange;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<BoardLike> likes;

    private Integer vaccineDose;

    private VaccineType vaccineType;

    // Symptom
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

    protected BoardDto(Board entity) {
        this.boardId = entity.getBoardId();

        this.userId = entity.getUser().getUserId();
        this.nickname = entity.getUser().getNickname();
        this.ageRange = entity.getAgeRange();

        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();

        this.likes = entity.getLikes();

        this.vaccineDose = entity.getVaccineDose();
        this.vaccineType = entity.getVaccineType();

        this.musclePain = entity.isMusclePain();
        this.fever = entity.isFever();
        this.chill = entity.isChill();
        this.nausea = entity.isNausea();
        this.diarrhea = entity.isDiarrhea();
        this.headache = entity.isHeadache();
        this.throatPain = entity.isThroatPain();
        this.fatigue = entity.isFatigue();
        this.allergy = entity.isAllergy();
        this.etc = entity.isEtc();

    }

    public static BoardDto ofEntity(Board entity) {
        return new BoardDto(entity);
    }

    public static List<BoardDto> ofEntities(List<Board> entities) {
        return entities.stream().map(BoardDto::ofEntity).collect(Collectors.toList());
    }

}
