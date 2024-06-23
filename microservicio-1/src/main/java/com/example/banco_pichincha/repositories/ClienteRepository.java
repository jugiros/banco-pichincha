package com.example.banco_pichincha.repositories;

import com.example.banco_pichincha.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
