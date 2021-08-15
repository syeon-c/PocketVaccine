package com.pocketvaccine.PocketVaccine.controlloer;

import com.pocketvaccine.PocketVaccine.domain.board.dto.BoardDto;
import com.pocketvaccine.PocketVaccine.domain.board.entity.Board;
import com.pocketvaccine.PocketVaccine.domain.common.ResultEntity;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.Symptom;
import com.pocketvaccine.PocketVaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvaccine.PocketVaccine.service.symptom.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home/data")
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomService symptomService;

    @GetMapping("/{vaccineDose}")
    public ResponseEntity<List<SymptomMapping>> showSymptoms(@PathVariable int vaccineDose) {
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
