package com.pocketvaccine.PocketVaccine.service.symptom;


//import com.pocketvaccine.PocketVaccine.domain.symptom.dto.SymptomDto;
import com.pocketvaccine.PocketVaccine.domain.symptom.dto.SymptomDto;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomId;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvaccine.PocketVaccine.repository.SymptomRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {
    final SymptomRepository symptomRepository;

//    @Override
//    public Symptom save(SymptomDto symptomDto) {
//        SymptomId symptomId = SymptomId.builder()
//                .boardId(symptomDto.getSymptomId().getBoardId())
//                .symptom(symptomDto.getSymptomId().getSymptom())
//                .build();
//
//        Symptom symptom = new Symptom();
//        symptom.setSymptomId(symptomId);
//        symptomRepository.save(symptom);
//
//        return symptom;
//    }

    @Override
    public List<SymptomMapping> showSymptom(int vaccineDose) {
        return symptomRepository.findSymptom(vaccineDose);
    }

}
