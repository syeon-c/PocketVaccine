package com.pocketvccn.pocketvaccine.service.symptom;

import com.pocketvccn.pocketvaccine.domain.symptom.entity.Symptom;
import com.pocketvccn.pocketvaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvccn.pocketvaccine.domain.user.type.Gender;

import java.util.List;

public interface SymptomService {

    List<SymptomMapping> showSymptom(int vaccineNum, Gender gender);

}
