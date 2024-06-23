package com.example.banco_pichincha.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends Persona {
    private String clienteId;
    private String contraseña;
    private boolean estado;
}
