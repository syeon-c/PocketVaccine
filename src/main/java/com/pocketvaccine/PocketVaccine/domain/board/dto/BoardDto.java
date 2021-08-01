package com.pocketvaccine.PocketVaccine.domain.board.dto;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString
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

    private VaccineType vaccineType;

    protected BoardDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.vaccineType = entity.getVaccineType();
    }

    public static BoardDto ofEntity(Board entity) {
        return new BoardDto(entity);
    }

}
