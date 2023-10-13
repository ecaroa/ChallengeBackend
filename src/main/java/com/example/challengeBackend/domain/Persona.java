package com.example.challengeBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Persona {

    private int personaID;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private LocalDate fechaNacimiento;
}
