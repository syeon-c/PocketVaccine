package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;

    @Override
    public Board save(BoardDto boardDto) {
        Board board = Board.builder()
                .userId(boardDto.getUserId())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .vaccineType(boardDto.getVaccineType())
                .build();
        boardRepository.save(board);

        return board;
    }

    @Override
    public Optional<Board> findById(Long boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    public Page<Board> findAll(Integer page, Integer size) {
        return boardRepository.findAll(PageRequest.of(page, size, Sort.by("boardId").descending()));
    }

    @Override
    public Page<Board> findByUserId(Long userId, Integer page, Integer size) {
        return boardRepository.findAllByUserIdOrderByBoardIdDesc(userId, PageRequest.of(page, size));
    }
}
