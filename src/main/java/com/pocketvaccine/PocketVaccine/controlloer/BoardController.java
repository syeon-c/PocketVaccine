package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.common.Paginate;
import com.pocketvaccine.PocketVaccine.domain.common.ResultCode;
import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;
import com.pocketvaccine.PocketVaccine.domain.common.ResultEntity;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.repository.UserRepository;
import com.pocketvaccine.PocketVaccine.service.board.BoardService;
import java.util.Optional;

import com.pocketvaccine.PocketVaccine.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity save(@RequestBody BoardDto boardDto) {
        ResultDto<Board> resultDto = boardService.save(boardDto);
        if(resultDto.getCode() == ResultCode.USER_NOT_FOUND.toString()) {
            return ResultEntity.notFound(ResultCode.USER_NOT_FOUND, "USER_NOT_FOUND");
        }
        boardDto.setBoardId(resultDto.getData().getBoardId());
        return ResultEntity.created("/api/boards/" + boardDto.getBoardId(), boardDto);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity getBoard(@PathVariable Long boardId) {
        Optional<Board> board = boardService.findById(boardId);
        if (board.isPresent()) {
            return ResultEntity.ok(BoardDto.ofEntity(board.get()));
        }
        return ResultEntity.notFound(ResultCode.BOARD_NOT_FOUND, "board not found");
    }

    @GetMapping("")
    public ResponseEntity getBoards(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) VaccineType vaccineType,
            @RequestParam(required = false) Integer vaccineDose,
            @RequestParam(required = false) String ageRange,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Page<Board> boardList;
        if(Optional.ofNullable(userId).isPresent()) {
            Optional<User> user = userRepository.findById(userId);
            boardList = boardService.findByUser(user.get(), page, size);
        } else if(Optional.ofNullable(vaccineType).isPresent()) {
            boardList = boardService.findByVaccineType(vaccineType, page, size);
        } else if(Optional.ofNullable(vaccineDose).isPresent()) {
            boardList = boardService.findByVaccineDose(vaccineDose, page, size);
        } else if(Optional.ofNullable(ageRange).isPresent()) {
            boardList = boardService.findByAge(page, size);
        } else {
            boardList = boardService.findAll(page, size);
        }
        return ResultEntity.ok(BoardDto.ofEntities(boardList.getContent()), Paginate.setPaginate(boardList));

    }

    @DeleteMapping("/{boardId}")
    public void delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
    }

}
