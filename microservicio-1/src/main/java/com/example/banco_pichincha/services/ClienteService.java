package com.example.banco_pichincha.services;

import com.example.banco_pichincha.dtos.ClientePersonaDTO;
import com.example.banco_pichincha.entities.Cliente;
import com.example.banco_pichincha.entities.Persona;
import com.example.banco_pichincha.repositories.ClienteRepository;
import com.example.banco_pichincha.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
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
    private PersonaRepository personaRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente save(ClientePersonaDTO clientePersonaDTO) {
        Persona persona = new Persona();
        persona.setNombre(clientePersonaDTO.getNombre());
        persona.setGenero(clientePersonaDTO.getGenero());
        persona.setEdad(clientePersonaDTO.getEdad());
        persona.setIdentificacion(clientePersonaDTO.getIdentificacion());
        persona.setDireccion(clientePersonaDTO.getDireccion());
        persona.setTelefono(clientePersonaDTO.getTelefono());

        Persona savedPersona = personaRepository.save(persona);

        Cliente cliente = new Cliente();
        cliente.setCliente_id(clientePersonaDTO.getCliente_id());
        cliente.setContraseña(clientePersonaDTO.getContraseña());
        cliente.setEstado(clientePersonaDTO.isEstado());
        cliente.setPersona(savedPersona);

        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
