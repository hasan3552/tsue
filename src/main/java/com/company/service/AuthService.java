package com.company.service;

import com.company.config.CustomUserDetails;
import com.company.dto.AuthDTO;
import com.company.dto.ProfileDTO;
import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import com.company.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final AuthenticationManager authenticationManager;
    private final ProfileRepository profileRepository;


    public ProfileDTO login(AuthDTO authDTO) {

        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authDTO.getUsername(),authDTO.getPassword()));

        CustomUserDetails user = (CustomUserDetails) authenticate.getPrincipal();
        ProfileEntity profile = user.getProfile();
        ProfileDTO dto = new ProfileDTO();
        dto.setUsername(profile.getUsername());
        dto.setJwt(JwtUtil.encode(profile.getId()));
        dto.setCourse(profile.getCourse());
        dto.setName(profile.getName());
        dto.setRole(profile.getRole());
        dto.setSurname(profile.getSurname());


        return dto;
    }


}
