package com.example.banco_pichincha.repositories;

import com.example.banco_pichincha.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, Date startDate, Date endDate);
}
