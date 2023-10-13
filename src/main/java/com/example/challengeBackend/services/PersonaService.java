package com.example.challengeBackend.services;

import com.example.challengeBackend.Repository.PersonaRepository;
import com.example.challengeBackend.entities.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    public void save(PersonaEntity personaEntity)
    {
        personaRepository.save(personaEntity);
    }

    public Boolean existEmail(String email) {
        return personaRepository.findByEmail(email).isPresent();
    }
}
