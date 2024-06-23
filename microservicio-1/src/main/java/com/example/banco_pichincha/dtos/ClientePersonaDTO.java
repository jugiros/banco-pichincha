package com.example.banco_pichincha.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePersonaDTO {
    private Long id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private Long cliente_id;
    private String contraseña;
    private boolean estado;
}
