package com.bank.itrade.auth.controller;

import com.bank.itrade.auth.dto.ProfileDTO;
import com.bank.itrade.auth.entity.Profile;
import com.bank.itrade.auth.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/{operatorId}")
    public List<ProfileDTO> getProfiles(@PathVariable String operatorId) {

        List<Profile> profiles = profileRepository.findByOperatorId(operatorId);

        return profiles.stream()
                .map(p -> new ProfileDTO(p.getCode(), p.getDescription()))
                .collect(Collectors.toList());
    }
}