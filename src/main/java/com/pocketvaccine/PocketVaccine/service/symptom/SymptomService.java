package com.pocketvaccine.PocketVaccine.service.symptom;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvaccine.PocketVaccine.domain.user.type.Gender;

import java.util.List;

public interface SymptomService {

    List<SymptomMapping> showSymptom(int vaccineDose, Gender gender);

}
