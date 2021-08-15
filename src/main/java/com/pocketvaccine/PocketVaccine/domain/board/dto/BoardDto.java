package com.pocketvaccine.PocketVaccine.domain.board.dto;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDto {

    private Long boardId;

    private Long userId;

    private String userName;

    private String userRange;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer vaccineDose;

    private VaccineType vaccineType;

    private List<Symptom> symptoms;

    protected BoardDto(Board entity) {
        this.boardId = entity.getBoardId();

        this.userId = entity.getUser().getUserId();
        this.userName = entity.getUser().getUserName();
        this.userRange = entity.getAgeRange();

        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();

        this.vaccineDose = entity.getVaccineDose();
        this.vaccineType = entity.getVaccineType();

        this.symptoms = entity.getSymptoms();
    }

    public static BoardDto ofEntity(Board entity) {
        return new BoardDto(entity);
    }

    public static List<BoardDto> ofEntities(List<Board> entities) {
        return entities.stream().map(BoardDto::ofEntity).collect(Collectors.toList());
    }

}
