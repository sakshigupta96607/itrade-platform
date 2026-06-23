package com.bank.itrade.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    private String operatorId;
    private String password;

}


