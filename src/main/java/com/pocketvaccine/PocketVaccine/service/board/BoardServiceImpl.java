package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.common.ResultCode;
import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomId;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import com.pocketvaccine.PocketVaccine.repository.SymptomRepository;
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

    final SymptomRepository symptomRepository;

    @Override
    public ResultDto<Board> save(BoardDto boardDto) {
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
                .vaccineDose(boardDto.getVaccineDose())
                .vaccineType(boardDto.getVaccineType())
                .symptoms(boardDto.getSymptoms())
                .build();

//        SymptomId symptomId = SymptomId.builder()
//                .boardId(boardDto.getBoardId())
//                .symptom(symptom.getSymptomId().getSymptom())
//                .build();
//
//        Symptom symptom1 = Symptom.builder()
//                .symptomId(symptomId)
//                .build();
//
//        board.getSymptoms().add(symptom1);
//        Symptom symptom1 = new Symptom();
//        symptom1.setSymptomId(symptomId);

        boardRepository.save(board);
//        symptomRepository.save(symptom1);

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
    public Page<Board> findByAge(Integer page, Integer size) {
        return boardRepository.findByAgeRange(PageRequest.of(page, size));
    }
}
