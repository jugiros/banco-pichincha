package com.example.banco_pichincha.services;

import com.example.banco_pichincha.entities.Movimiento;
import com.example.banco_pichincha.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }

    public List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, Date startDate, Date endDate) {
        return movimientoRepository.findByCuentaIdAndFechaBetween(cuentaId, startDate, endDate);
    }
}
