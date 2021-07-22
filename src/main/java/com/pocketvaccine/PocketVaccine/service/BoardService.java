package com.pocketvaccine.PocketVaccine.service;

import com.pocketvaccine.PocketVaccine.domain.Board;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import com.pocketvaccine.PocketVaccine.repository.MemoryBoardRepository;

import java.util.Optional;

public class BoardService {
    private final BoardRepository boardRepository = new MemoryBoardRepository();

    public Long upload(Board board) {
        boardRepository.save(board);
        return board.getBoardNo();
    }

    public Optional<Board> findBoard(Long boardNo) {
        return boardRepository.findByBoardNo(boardNo);
    }
}
