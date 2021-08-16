package com.pocketvaccine.PocketVaccine.service.symptom;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvaccine.PocketVaccine.repository.SymptomRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {
    final SymptomRepository symptomRepository;

    @Override
    public List<SymptomMapping> showSymptom(Integer vaccineDose) {
        return symptomRepository.findSymptom(vaccineDose);
    }

}
