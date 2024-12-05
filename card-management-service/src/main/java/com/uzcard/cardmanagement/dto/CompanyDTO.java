package com.uzcard.cardmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyDTO {
    private String name;
    private String address;
    private String contact;
    private boolean visible;
    private String role;
    private String code;
    private String username;
    private String password;

}
