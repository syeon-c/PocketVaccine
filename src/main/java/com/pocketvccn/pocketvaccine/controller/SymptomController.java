package com.pocketvccn.pocketvaccine.controller;

import com.pocketvccn.pocketvaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvccn.pocketvaccine.domain.user.type.Gender;
import com.pocketvccn.pocketvaccine.service.symptom.SymptomService;
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
    
    @GetMapping("")
    public ResponseEntity showSymptoms(@RequestParam(required = false) int vaccineNum,
                                       @RequestParam(required = false) Gender gender) {
        List<SymptomMapping> symptomList = null;
        if(Optional.ofNullable(vaccineNum).isPresent() && Optional.ofNullable(gender).isPresent()) {
            symptomList = symptomService.showSymptom(vaccineNum, gender);
        }
        return ResponseEntity.ok(symptomList);
    }

}
