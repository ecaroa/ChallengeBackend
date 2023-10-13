package com.example.challengeBackend.Repository;

import com.example.challengeBackend.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Integer>{
    public Optional<UsuarioEntity> findByUsername(String username);

    public Optional<UsuarioEntity> findByUsernameAndPassword(String username, String password);
}
