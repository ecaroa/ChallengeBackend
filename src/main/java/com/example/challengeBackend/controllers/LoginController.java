package com.example.challengeBackend.controllers;

import com.example.challengeBackend.exceptions.LoginException;
import com.example.challengeBackend.models.request.LoginRequest;
import com.example.challengeBackend.models.response.GenericResponse;
import com.example.challengeBackend.models.response.LoginResponse;
import com.example.challengeBackend.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("auth/login")
    public ResponseEntity<LoginResponse > login(@Valid @RequestBody LoginRequest body) throws LoginException {
        try {
           return ResponseEntity.ok().body(new LoginResponse(usuarioService.existUsernameAndPassword(body.getUser(), body.getPassword())));
        } catch (Exception e) {
            throw new LoginException("Ocurrió un error al llevar a cabo el login.");
        }
    }
}
