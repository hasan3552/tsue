package com.company.controller;

import com.company.dto.AuthDTO;
import com.company.dto.ProfileDTO;
import com.company.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

//    @PostMapping("/public/registration")
//    public ResponseEntity<?> registration(@RequestBody @Valid RegistrationDTO dto) {
//
//        String response = authService.registration(dto);
//        return ResponseEntity.ok().body(response);
//    }


    @PostMapping("/login")
    public ResponseEntity<ProfileDTO> login(@RequestBody @Valid AuthDTO dto) {


        ProfileDTO profileDto = authService.login(dto);
        return ResponseEntity.ok().body(profileDto);
    }


}
