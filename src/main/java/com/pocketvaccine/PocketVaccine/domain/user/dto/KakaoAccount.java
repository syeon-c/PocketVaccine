package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KakaoAccount {

    @JsonProperty(value = "email")
    String accountEmail;

    @JsonProperty(value = "age_range")
    String ageRange;

}
