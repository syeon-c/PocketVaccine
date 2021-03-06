package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface BoardService {

    <T> ResultDto<T> post(BoardDto boardDto);

//    <T> ResultDto<T> update(Long boardId, BoardDto boardDto);

    void delete(Long boardId);

    Optional<Board> findById(Long boardId);

    Page<Board> findAll(Integer page, Integer size);

    Page<Board> findByUser(User user, Integer page, Integer size);

    Page<Board> findByVaccineType(VaccineType vaccineType, Integer page, Integer size);

    Page<Board> findByVaccineDose(Integer vaccineDose, Integer page, Integer size);

    Page<Board> findByAgeRange(String ageRange, Integer page, Integer size);

}
