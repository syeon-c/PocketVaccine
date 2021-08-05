package com.pocketvaccine.PocketVaccine.domain.user.dto;

import com.pocketvaccine.PocketVaccine.domain.user.type.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KakaoAccount {

    String nickName;

    String accountEmail;

    Gender gender;

    String ageRange;

}
