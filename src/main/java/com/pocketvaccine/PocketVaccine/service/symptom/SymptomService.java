package com.pocketvaccine.PocketVaccine.service.symptom;


//import com.pocketvaccine.PocketVaccine.domain.symptom.dto.SymptomDto;
import com.pocketvaccine.PocketVaccine.domain.symptom.dto.SymptomDto;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;

import java.util.List;

public interface SymptomService {
//    Symptom save(SymptomDto symptomDto);
    List<SymptomMapping> showSymptom(int vaccineDose);


}
