package com.bank.itrade.auth.service;

import com.bank.itrade.auth.entity.Operator;
import com.bank.itrade.auth.repository.OperatorRepository;
import com.bank.itrade.auth.dto.LoginRequest;
import com.bank.itrade.auth.dto.LoginResponse;
import com.bank.itrade.auth.dto.ProfileDTO;
import com.bank.itrade.auth.entity.Profile;
import com.bank.itrade.auth.repository.ProfileRepository;
import com.bank.itrade.auth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final OperatorRepository operatorRepository;
    private final ProfileRepository profileRepository;
    private final JwtUtil jwtUtil;

    // ✅ Constructor Injection (BEST PRACTICE)
    @Autowired
    public AuthService(OperatorRepository operatorRepository,
                       ProfileRepository profileRepository,
                       JwtUtil jwtUtil) {
        this.operatorRepository = operatorRepository;
        this.profileRepository = profileRepository;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {

        // ✅ Fetch operator
        Operator operator = operatorRepository
                .findByOperatorId(request.getOperatorId())
                .orElseThrow(() -> new RuntimeException("Invalid operatorId"));

        // ✅ Validate password
        if (!operator.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // 🔐 Generate JWT
        String token = jwtUtil.generateToken(operator.getOperatorId());

        // 📌 Fetch profiles
        List<Profile> profiles = profileRepository
                .findByOperatorId(operator.getOperatorId());

        // 📦 Convert to DTO
        List<ProfileDTO> profileDTOs = profiles.stream()
                .map(p -> new ProfileDTO(p.getCode(), p.getDescription()))
                .collect(Collectors.toList());

        // ✅ Final response (token + profiles)
        return new LoginResponse(token, operator.getOperatorId(), profileDTOs);
    }
}

