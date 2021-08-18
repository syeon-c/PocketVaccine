package com.pocketvaccine.PocketVaccine.service.board;

import com.pocketvaccine.PocketVaccine.domain.board.entity.BoardLike;
import com.pocketvaccine.PocketVaccine.domain.common.ResultDto;

import java.util.Map;


public interface BoardLikeService {

    Integer getLikes(Long boardId);

    <T> ResultDto<T> addLike(Long boardId, Long userId);

    void deleteLike(Long boardId, Long likeHistoryId, Long userId);
}
