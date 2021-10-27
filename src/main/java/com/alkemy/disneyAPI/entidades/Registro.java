package com.alkemy.disneyAPI.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Registro {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String password;
}
