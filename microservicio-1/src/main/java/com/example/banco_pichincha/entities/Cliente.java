package com.example.banco_pichincha.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String contraseña;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}
