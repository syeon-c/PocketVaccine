package com.pocketvccn.pocketvaccine.service.symptom;

import com.pocketvccn.pocketvaccine.domain.symptom.entity.Symptom;
import com.pocketvccn.pocketvaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvccn.pocketvaccine.domain.user.type.Gender;
import com.pocketvccn.pocketvaccine.repository.SymptomRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {
    final SymptomRepository symptomRepository;

    @Override
    public List<SymptomMapping> showSymptom(int vaccineNum, Gender gender) {
        return symptomRepository.findSymptom(vaccineNum, gender);
    }

}
