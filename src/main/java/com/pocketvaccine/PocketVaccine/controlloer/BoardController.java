package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.common.ResultEntity;
import com.pocketvaccine.PocketVaccine.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity uploadBoard(@RequestBody BoardDto boardDto) {
        Board board = boardService.save(boardDto);
        boardDto.setBoardId(board.getBoardId());
        return ResultEntity.created("/api/boards/" + boardDto.getBoardId(), boardDto);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity getBoard(@PathVariable Long boardNo) {
        Optional<Board> board = boardService.findById(boardNo);

        if (board.isPresent()) {
            return ResponseEntity.ok(board.get());
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
