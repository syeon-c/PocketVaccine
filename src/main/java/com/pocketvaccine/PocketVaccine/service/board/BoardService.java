package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface BoardService {

    Board save(BoardDto boardDto);

    Optional<Board> findById(Long boardId);

    Page<Board> findAll(Integer page, Integer size);

    Page<Board> findByUserId(Long userId, Integer page, Integer size);

    Page<Board> findByVaccineType(VaccineType vaccineType, Integer page, Integer size);
}
