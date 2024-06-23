package com.example.banco_pichincha.repositories;

import com.example.banco_pichincha.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
