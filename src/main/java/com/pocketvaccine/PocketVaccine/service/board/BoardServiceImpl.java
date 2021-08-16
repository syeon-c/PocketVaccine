package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.common.ResultCode;
import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import com.pocketvaccine.PocketVaccine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;

    final UserRepository userRepository;

    @Override
    public ResultDto<Board> post(BoardDto boardDto) {
        ResultDto<Board> resultDto = new ResultDto<>();

        Optional<User> user = userRepository.findById(boardDto.getUserId());
        if (!user.isPresent()) {
            resultDto.setCode(ResultCode.USER_NOT_FOUND.toString());
            return resultDto;
        }

        Board board = Board.builder()
                .user(user.get())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .ageRange(boardDto.getAgeRange())
//                .createdAt(boardDto.getCreatedAt())
                .likes(0)
                .vaccineDose(boardDto.getVaccineDose())
                .vaccineType(boardDto.getVaccineType())
                .musclePain(boardDto.isMusclePain())
                .fever(boardDto.isFever())
                .chill(boardDto.isChill())
                .nausea(boardDto.isNausea())
                .diarrhea(boardDto.isDiarrhea())
                .headache(boardDto.isHeadache())
                .throatPain(boardDto.isThroatPain())
                .fatigue(boardDto.isFatigue())
                .allergy(boardDto.isAllergy())
                .etc(boardDto.isEtc())
                .build();
        boardRepository.save(board);

        resultDto.setCode(ResultCode.SUCCESS.toString());
        resultDto.setData(board);

        return resultDto;
    }

    @Override
    @Transactional
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
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
    public Page<Board> findByUser(User user, Integer page, Integer size) {
        return boardRepository.findAllByUserOrderByBoardIdDesc(user, PageRequest.of(page, size));
    }

    @Override
    public Page<Board> findByVaccineType(VaccineType vaccineType, Integer page, Integer size) {
        return boardRepository.findAllByVaccineTypeOrderByBoardIdDesc(vaccineType, PageRequest.of(page, size));
    }

    @Override
    public Page<Board> findByVaccineDose(Integer vaccineDose, Integer page, Integer size) {
        return boardRepository.findAllByVaccineDoseOrderByBoardIdDesc(vaccineDose, PageRequest.of(page, size));
    }

    @Override
    public Page<Board> findByAgeRange(String ageRange, Integer page, Integer size) {
        return boardRepository.findByAgeRange(PageRequest.of(page, size));
    }
}
