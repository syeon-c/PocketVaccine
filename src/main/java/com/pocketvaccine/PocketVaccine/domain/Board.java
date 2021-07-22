package com.pocketvaccine.PocketVaccine.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {

    private Long boardNo;
    private String title;
    private String content;
    private int vaccineNo;

}
