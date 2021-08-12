package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAll(Pageable pageable);

    Page<Board> findAllByUserIdOrderByBoardIdDesc(Long userId, PageRequest pageable);

    Page<Board> findAllByVaccineTypeOrderByBoardIdDesc(VaccineType vaccineType, PageRequest pageRequest);

    Page<Board> findAllByVaccineDoseOrderByBoardIdDesc(Integer vaccineDose, PageRequest pageRequest);

//    Page<Board> findAllByAgeOrderByBoardIdDesc(Integer age, PageRequest pageRequest);

    @Query("select b from Board b join b.user u where u.age = :age")
    Page<Board> findByUserAge(@Param("age") Integer age, PageRequest pageRequest);
}
