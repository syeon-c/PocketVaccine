package com.pocketvaccine.PocketVaccine.api;

import com.pocketvaccine.PocketVaccine.domain.Board;
import com.pocketvaccine.PocketVaccine.service.BoardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("api/v1/boards")
    public CreateBoardResponse uploadBoard(@RequestBody Board board) {
        Long boardNo = boardService.upload(board);
        return new CreateBoardResponse(boardNo);
    }

    @Data
    static class CreateBoardResponse {
        private Long boardNo;

        public CreateBoardResponse(Long boardNo) {
            this.boardNo = boardNo;
        }
    }
}
