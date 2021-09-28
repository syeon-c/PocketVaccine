package com.pocketvaccine.PocketVaccine.controller;

import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvaccine.PocketVaccine.service.symptom.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/data")
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomService symptomService;

    @GetMapping("/{vaccineDose}")
    public ResponseEntity<List<SymptomMapping>> showSymptoms(@PathVariable Integer vaccineDose) {
        ResponseEntity<List<SymptomMapping>> symptomList = null;

        try {
            symptomList = new ResponseEntity<>(symptomService.showSymptom(vaccineDose), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            symptomList = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return symptomList;
    }

}
