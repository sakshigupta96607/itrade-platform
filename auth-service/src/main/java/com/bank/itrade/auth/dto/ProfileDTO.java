package com.bank.itrade.auth.dto;

import lombok.Getter;

@Getter
public class ProfileDTO {

    private String code;
    private String description;

    public ProfileDTO(String code, String description) {
        this.code = code;
        this.description = description;
    }

}