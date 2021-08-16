package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.entity.BoardLike;
import com.pocketvaccine.PocketVaccine.domain.common.LikeExceptionType;
import com.pocketvaccine.PocketVaccine.domain.common.*;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import com.pocketvaccine.PocketVaccine.repository.BoardLikeRepository;
import com.pocketvaccine.PocketVaccine.repository.BoardRepository;
import com.pocketvaccine.PocketVaccine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardLikeServiceImpl implements BoardLikeService {

    final BoardRepository boardRepository;

    final UserRepository userRepository;

    final BoardLikeRepository boardLikeRepository;


    @Override
    public Integer getLikes(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() ->
                new FreeBoardException(BoardExceptionType.NOT_FOUND_CONTENTS));
        int countLike = boardLikeRepository.countByBoard(board);
        return countLike;
    }

    @Override
    public ResultDto<BoardLike> addLike(Long boardId, Long userId) {
        ResultDto<BoardLike> resultDto = new ResultDto<>();
        Optional<User> optionalUser = Optional.of(userRepository.findById(userId)).orElseThrow(() ->
                new FreeBoardException(UserExceptionType.NOT_FOUND_USER));
        User user = optionalUser.get();
        Board board = Optional.of(boardRepository.findById(boardId).get()).orElseThrow(() ->
                new FreeBoardException(BoardExceptionType.NOT_FOUND_CONTENTS));

        if (board.getUser().getUserId().equals(user)) {
            throw new FreeBoardException(LikeExceptionType.CANNOT_FIND_HISTORY);
        }

        // 이미 좋아요 누름
        boardLikeRepository.findByBoardAndUser(board, user).ifPresent(none -> {
                throw new FreeBoardException(LikeExceptionType.HISTORY_ALREADY_EXISTS);
        });

        BoardLike boardLike = BoardLike.builder()
                .board(board)
                .user(user)
                .build();
        boardLikeRepository.save(boardLike);

        resultDto.setCode(ResultCode.SUCCESS.toString());
        resultDto.setData(boardLike);

        return resultDto;
    }

    @Override
    public void deleteLike(Long boardId, Long likeHistoryId, Long userId) {
        Optional<User> optionalUser = Optional.of(userRepository.findById(userId)).orElseThrow(() ->
                new FreeBoardException(UserExceptionType.NOT_FOUND_USER));
        User user = optionalUser.get();
        Board board = Optional.of(boardRepository.findById(boardId).get()).orElseThrow(() ->
                new FreeBoardException(BoardExceptionType.NOT_FOUND_CONTENTS));

        boardLikeRepository.findByBoardAndUser(board, user).orElseThrow(() ->
            new FreeBoardException(LikeExceptionType.CANNOT_FIND_HISTORY));

        boardLikeRepository.deleteById(likeHistoryId);
    }
}
