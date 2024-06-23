package com.example.banco_pichincha.services;

import com.example.banco_pichincha.dtos.ClientePersonaDTO;
import com.example.banco_pichincha.entities.Cliente;
import com.example.banco_pichincha.entities.Persona;
import com.example.banco_pichincha.repositories.ClienteRepository;
import com.example.banco_pichincha.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PersonaServiceTest {
    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    public PersonaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCliente() {
        Persona persona = new Persona();
        persona.setNombre("Jose Lema");
        when(personaRepository.save(persona)).thenReturn(persona);
        Persona savedPersona = personaService.save(persona);
        assertEquals(persona.getNombre(), savedPersona.getNombre());
    }
}
