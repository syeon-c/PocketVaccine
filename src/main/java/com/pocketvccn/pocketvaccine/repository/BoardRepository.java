package com.pocketvccn.pocketvaccine.repository;

import com.pocketvccn.pocketvaccine.domain.board.entity.Board;
import com.pocketvccn.pocketvaccine.domain.board.type.VaccineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findAll(Pageable pageable);

    Page<Board> findAllByUserIdOrderByBoardIdDesc(Long userId, PageRequest pageable);

    Page<Board> findAllByVaccineTypeOrderByBoardIdDesc(VaccineType vaccineType, PageRequest pageRequest);
}
