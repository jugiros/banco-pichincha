package com.example.banco_pichincha.services;

import com.example.banco_pichincha.entities.Cliente;
import com.example.banco_pichincha.repositories.ClienteRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        rabbitTemplate.convertAndSend("cuentaQueue", savedCliente);
        return savedCliente;
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
