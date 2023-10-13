package com.example.challengeBackend.controllers;

import com.example.challengeBackend.exceptions.RegistrationException;
import com.example.challengeBackend.models.request.RegistrationRequest;
import com.example.challengeBackend.models.response.GenericResponse;
import com.example.challengeBackend.models.response.ValidEmailResponse;
import com.example.challengeBackend.models.response.ValidUsernameResponse;
import com.example.challengeBackend.services.PersonaService;
import com.example.challengeBackend.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PersonaService personaService;

    @PostMapping("auth/register")
    public ResponseEntity<GenericResponse> createUser(@Valid @RequestBody RegistrationRequest body ) throws RegistrationException {
        //aca creamos la persona y el usuario por medio del service.
        try {
            usuarioService.createUser(body.getNombre(), body.getApellido(), body.getEmail(),
                    body.getTelefono(), body.getFechaNacimiento(),body.getUser(),body.getPassword());

            return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse("Registro realizado correctamente"));
        } catch (Exception e) {
            throw new RegistrationException("Ocurrió un error al llevar a cabo el registro.");
        }
    }

    @GetMapping("users/{username}/validate")
    public ResponseEntity<ValidUsernameResponse> validateUsername(@PathVariable String username ) throws RegistrationException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ValidUsernameResponse(!usuarioService.existUsername(username)));
        } catch (Exception e) {
            throw new RegistrationException("Ocurrió un error al validar el username.");
        }
    }

    @GetMapping("personas/{email}/validate")
    public ResponseEntity<ValidEmailResponse> validEmailResponse(@PathVariable String email) throws RegistrationException{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ValidEmailResponse(!personaService.existEmail(email)));
        }catch (Exception e){
            throw  new RegistrationException("Ocurrió un error al validar el email.");
        }
    }
}
