package com.uzcard.cardmanagement.config;

import lombok.Getter;

@Getter
public class CustomUserDetails {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public CustomUserDetails(String email, Integer id, String name, String password, String surname) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }
}
