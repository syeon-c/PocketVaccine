package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoProperty {

    @JsonProperty(value = "nickname")
    private String nickName;

}
