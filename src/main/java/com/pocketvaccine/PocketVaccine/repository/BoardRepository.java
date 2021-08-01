package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAll(Pageable pageable);

    Page<Board> findAllByUserIdOrderByBoardIdDesc(Long userId, PageRequest pageable);

}
