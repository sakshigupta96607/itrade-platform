package com.bank.itrade.auth.dto;

import java.util.List;

public class LoginResponse {

    private String token;
    private String operatorId;
    private List<ProfileDTO> profiles;

    public LoginResponse(String token, String operatorId, List<ProfileDTO> profiles) {
        this.token = token;
        this.operatorId = operatorId;
        this.profiles = profiles;
    }

    public String getToken() {
        return token;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }
}