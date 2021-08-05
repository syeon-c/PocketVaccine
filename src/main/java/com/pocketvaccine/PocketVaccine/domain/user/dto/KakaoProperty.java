package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoProperty {

    @JsonProperty(value = "nickname")
    private String nickName;

    @JsonProperty(value = "profile_image")
    private String profileImage;

    @JsonProperty(value = "thumbnail_image")
    private String thumbnailImage;

}
