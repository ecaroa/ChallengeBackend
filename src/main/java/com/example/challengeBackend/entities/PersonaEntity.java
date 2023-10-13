package com.example.challengeBackend.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personaID;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne(mappedBy = "personaEntity", cascade = CascadeType.ALL)
    private UsuarioEntity usuario;
}