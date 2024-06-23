package com.example.banco_pichincha.services;

import com.example.banco_pichincha.entities.Cuenta;
import com.example.banco_pichincha.repositories.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("1234567890");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(1000.0);
        cuenta.setEstado(true);

        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        Cuenta savedCuenta = cuentaService.save(cuenta);

        assertNotNull(savedCuenta);
        assertEquals("1234567890", savedCuenta.getNumeroCuenta());
        assertEquals("Ahorros", savedCuenta.getTipoCuenta());
        assertEquals(1000.0, savedCuenta.getSaldoInicial());
        assertTrue(savedCuenta.isEstado());

        verify(cuentaRepository, times(1)).save(any(Cuenta.class));
    }
}
