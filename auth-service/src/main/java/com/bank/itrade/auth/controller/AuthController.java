package com.bank.itrade.auth.controller;

import com.bank.itrade.auth.dto.LoginRequest;
import com.bank.itrade.auth.dto.LoginResponse;
import com.bank.itrade.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}