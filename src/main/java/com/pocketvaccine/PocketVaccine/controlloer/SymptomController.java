package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvaccine.PocketVaccine.service.symptom.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home/data")
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomService symptomService;
    
    @GetMapping("/{vaccineDose}")
    public ResponseEntity showSymptoms(@PathVariable int vaccineDose) {
        List<SymptomMapping> symptomList = null;
        if(Optional.ofNullable(vaccineDose).isPresent()) {
            symptomList = symptomService.showSymptom(vaccineDose);
        }
        return ResponseEntity.ok(symptomList);
    }

}
