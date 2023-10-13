package com.example.challengeBackend.services;

import com.example.challengeBackend.Repository.UsuarioRepository;
import com.example.challengeBackend.entities.PersonaEntity;
import com.example.challengeBackend.entities.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaService personaService;

    @Transactional
    public void createUser(String nombre, String apellido, String email, String telefono,
                           LocalDate fechaNacimiento, String username,String password){
        PersonaEntity personaEntity = new PersonaEntity();

        personaEntity.setNombre(nombre);
        personaEntity.setApellido(apellido);
        personaEntity.setEmail(email);
        personaEntity.setTelefono(telefono);
        personaEntity.setFechaNacimiento(fechaNacimiento);


        UsuarioEntity newUsuarioEntity = new UsuarioEntity();
        newUsuarioEntity.setUsername(username);
        newUsuarioEntity.setPassword(password);
        newUsuarioEntity.setPersonaEntity(personaEntity);

        this.save(newUsuarioEntity);
    }

    public void save(UsuarioEntity e)  {
        this.usuarioRepository.save(e);
    }

    public Boolean existUsernameAndPassword(String username, String password){
        try {
            return usuarioRepository.findByUsernameAndPassword(username, password).isPresent();
        }catch (Exception e) {
            System.out.print(e.getMessage());
            throw e;
        }
    }

    public Boolean existUsername(String username) {
        return usuarioRepository.findByUsername(username).isPresent();
    }

}
