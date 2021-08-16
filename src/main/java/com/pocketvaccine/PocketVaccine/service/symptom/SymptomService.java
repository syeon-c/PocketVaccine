package com.pocketvaccine.PocketVaccine.service.symptom;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;

import java.util.List;

public interface SymptomService {
    List<SymptomMapping> showSymptom(Integer vaccineDose);


}
