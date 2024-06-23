package com.example.banco_pichincha.services;

import com.example.banco_pichincha.entities.Cliente;
import com.example.banco_pichincha.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    public ClienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Jose Lema");
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente savedCliente = clienteService.save(cliente);
        assertEquals(cliente.getNombre(), savedCliente.getNombre());
    }
}
