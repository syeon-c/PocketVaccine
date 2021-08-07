package com.pocketvccn.pocketvaccine.service.board;

import com.pocketvccn.pocketvaccine.domain.board.dto.BoardDto;
import com.pocketvccn.pocketvaccine.domain.board.entity.Board;
import com.pocketvccn.pocketvaccine.domain.board.type.VaccineType;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BoardService {
    Board save(BoardDto boardDto);

    Optional<Board> findById(Long boardId);

    Page<Board> findAll(Integer page, Integer size);

    Page<Board> findByUserId(Long userId, Integer page, Integer size);

    Page<Board> findByVaccineType(VaccineType vaccineType, Integer page, Integer size);
}
