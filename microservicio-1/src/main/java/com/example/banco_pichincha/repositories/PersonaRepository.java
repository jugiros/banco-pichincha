package com.example.banco_pichincha.repositories;

import com.example.banco_pichincha.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
