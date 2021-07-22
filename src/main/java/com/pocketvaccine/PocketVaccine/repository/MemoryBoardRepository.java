package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.Board;

import java.util.*;

public class MemoryBoardRepository implements BoardRepository{

    private static Map<Long, Board> database = new HashMap<>();

    public Board save(Board board) {
        board.setBoardNo(board.getBoardNo());
        database.put(board.getBoardNo(), board);
        return board;
    }

    @Override
    public Optional<Board> findByBoardNo(Long boardNo) {
        return Optional.ofNullable(database.get(boardNo));
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(database.values());
    }


}
