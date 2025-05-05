package com.example.piatto_pc1.controller;

import com.example.piatto_pc1.service.AuthenticationService;
import com.example.piatto_pc1.domain.Usuario;
import com.example.piatto_pc1.dto.JwtAuthenticationResponse;
import com.example.piatto_pc1.dto.SigninRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@Valid @RequestBody Usuario request) {
        return ResponseEntity.ok(authenticationService.signup(request));}

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@Valid @RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));}}