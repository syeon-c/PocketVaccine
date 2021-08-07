package com.pocketvccn.pocketvaccine.domain.symptom.entity;

import lombok.*;

public interface SymptomMapping {
    String getAges();
    Long getCountMusclePain();
    Long getCountFever();
    Long getCountChill();
    Long getCountHeadache();
}
