package com.example.banco_pichincha.services;

import com.example.banco_pichincha.entities.Cuenta;
import com.example.banco_pichincha.errors.ErrorMessages;
import com.example.banco_pichincha.exception.InvalidCuentaException;
import com.example.banco_pichincha.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta save(Cuenta cuenta) {
        if (ObjectUtils.isEmpty(cuenta.getCliente_id())) {
            throw new InvalidCuentaException(ErrorMessages.CLIENTE_ID_NULL);
        }
        return cuentaRepository.save(cuenta);
    }

    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
}
