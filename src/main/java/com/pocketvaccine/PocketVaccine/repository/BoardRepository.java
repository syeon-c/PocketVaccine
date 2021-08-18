package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.board.type.VaccineType;
import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAll(Pageable pageable);

    Page<Board> findAllByUserOrderByBoardIdDesc(User user, Pageable pageable);

    Page<Board> findAllByVaccineTypeOrderByBoardIdDesc(VaccineType vaccineType, Pageable pageRequest);

    Page<Board> findAllByVaccineDoseOrderByBoardIdDesc(Integer vaccineDose, Pageable pageRequest);

//    Page<Board> findAllByAgeOrderByBoardIdDesc(Integer age, PageRequest pageRequest);

    @Query("select b from Board b join b.user u where u.ageRange = :ageRange")
    Page<Board> findByAgeRange(@Param("ageRange") Pageable pageRequest);

}
