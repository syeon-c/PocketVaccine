package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomId;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, SymptomId> {
    @Query("select case when (b.user.age >= 90) then '90대' " +
            "when (b.user.age >= 80) then '80대' " +
            "when (b.user.age >= 70) then '70대' " +
            "when (b.user.age >= 60) then '60대' " +
            "when (b.user.age >= 50) then '50대' " +
            "when (b.user.age >= 40) then '40대' " +
            "when (b.user.age >= 30) then '30대' " +
            "when (b.user.age >= 20) then '20대' " +
            "else '10대' end as ages, " +
            "count(case when s.symptomId.symptom='근육통' then 1 end) as countMusclePain, " +
            "count(case when s.symptomId.symptom='발열' then 1 end) as countFever, " +
            "count(case when s.symptomId.symptom='오한' then 1 end) as countChill, " +
            "count(case when s.symptomId.symptom='두통' then 1 end) as countHeadache " +
            "from Symptom s join Board b on s.symptomId.boardId = b.boardId " +
//            "join User u on b.user.userId = u.userId " +
            "where b.vaccineDose= :vaccineDose and b.user.gender= :gender group by ages")
//    @Query("select s from Symptom s join Board b on s.symptomId.boardId = b.boardId " +
//            "join User u on b.userId = u.userId " +
//            "where b.vaccineDose= :vaccineDose and u.gender= :gender")
    List<SymptomMapping> findSymptom(@Param("vaccineDose") int vaccineRound);
}
