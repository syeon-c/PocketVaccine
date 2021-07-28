package com.pocketvaccine.PocketVaccine.service;

import com.pocketvaccine.PocketVaccine.domain.entity.Board;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    final BoardRepository boardRepository;

    @Transactional
    public Long save(Board board) {
        boardRepository.save(board);
        return board.getBoardNo();
    }

    public Optional<Board> findBoard(Long boardNo) {
        return boardRepository.findById(boardNo);
    }
}
