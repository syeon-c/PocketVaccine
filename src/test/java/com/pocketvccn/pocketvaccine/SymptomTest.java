package com.pocketvccn.pocketvaccine;


import com.pocketvccn.pocketvaccine.domain.symptom.entity.SymptomMapping;
import com.pocketvccn.pocketvaccine.domain.user.type.Gender;
import com.pocketvccn.pocketvaccine.repository.SymptomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SymptomTest {
    @Autowired
    SymptomRepository symptomRepository;

    @Test
    public void showSymptomTest() {
        List<SymptomMapping> result = symptomRepository.findSymptom(1, Gender.valueOf("FEMALE"));
        for(SymptomMapping sm : result) {
            System.out.print("나이대: " + sm.getAges() + ", 근육통: " + sm.getCountMusclePain() +
                            ", 발열: " + sm.getCountFever() + ", 오한: " + sm.getCountChill() +
                    ", 두통: " + sm.getCountHeadache());
            System.out.println();
        }

    }


}
