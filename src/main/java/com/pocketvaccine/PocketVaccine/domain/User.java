package com.pocketvaccine.PocketVaccine.domain;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

    private String id;
    private String name;
    private String password;
    private String gender;
    private int age;

}
