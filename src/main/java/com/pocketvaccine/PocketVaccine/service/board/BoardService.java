package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public interface BoardService {

    Board save(BoardDto boardDto);

    Optional<Board> findById(Long boardId);

    Page<Board> findAll(Integer page, Integer size);

    Page<Board> findByUserId(Long userId, Integer page, Integer size);
}
