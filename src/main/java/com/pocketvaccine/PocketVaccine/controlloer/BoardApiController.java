package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.entity.Board;
import com.pocketvaccine.PocketVaccine.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/boards")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity uploadBoard(@RequestBody Board board) {
        Long boardNo = boardService.save(board);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create("/api/v1/boards/" + boardNo));
        return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity getBoard(@PathVariable Long boardNo) {
        Optional<Board> board = boardService.findBoard(boardNo);

        if (board.isPresent()) {
            return ResponseEntity.ok(board.get());
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
