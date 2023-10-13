package com.example.challengeBackend.Repository;

import com.example.challengeBackend.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    public Optional<PersonaEntity> findByEmail(String email);
}
