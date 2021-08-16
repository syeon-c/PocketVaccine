package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Board, Long> {
    @Query("select b.ageRange as ageRange, " +
            "count(case when b.musclePain=true then 1 end) as countMusclePain, " +
            "count(case when b.fever=true then 1 end) as countFever, " +
            "count(case when b.chill=true then 1 end) as countChill, " +
            "count(case when b.nausea=true then 1 end) as countNausea," +
            "count(case when b.diarrhea=true then 1 end) as countDiarrhea," +
            "count(case when b.headache=true then 1 end) as countHeadache, " +
            "count(case when b.throatPain=true then 1 end) as countThroatPain, " +
            "count(case when b.fatigue=true then 1 end) as countFatigue, " +
            "count(case when b.allergy=true then 1 end) as countAllergy, " +
            "count(case when b.etc=true then 1 end) as countEtc " +
            "from Board b where b.vaccineDose= :vaccineDose group by ageRange")
    List<SymptomMapping> findSymptom(@Param("vaccineDose") Integer vaccineDose);
}
