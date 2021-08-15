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
    @Query("select b.ageRange, " +
            "count(case when s.symptomId.symptom='근육통' then 1 end) as countMusclePain, " +
            "count(case when s.symptomId.symptom='발열' then 1 end) as countFever, " +
            "count(case when s.symptomId.symptom='오한' then 1 end) as countChill, " +
            "count(case when s.symptomId.symptom='두통' then 1 end) as countHeadache " +
            "from Symptom s join Board b on s.symptomId.boardId = b.boardId " +
            "where b.vaccineDose= :vaccineDose group by ageRange")
    List<SymptomMapping> findSymptom(@Param("vaccineDose") int vaccineDose);
}
