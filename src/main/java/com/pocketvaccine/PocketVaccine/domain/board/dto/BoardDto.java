package com.pocketvaccine.PocketVaccine.domain.board.dto;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import java.util.List;
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

    private String title;

    private String content;

    private int vaccineDose;

    private VaccineType vaccineType;

    protected BoardDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.vaccineDose = entity.getVaccineDose();
        this.vaccineType = entity.getVaccineType();
    }

    public static BoardDto ofEntity(Board entity) {
        return new BoardDto(entity);
    }

    public static List<BoardDto> ofEntities(List<Board> entities) {
        return entities.stream().map(BoardDto::ofEntity).collect(Collectors.toList());
    }

}
