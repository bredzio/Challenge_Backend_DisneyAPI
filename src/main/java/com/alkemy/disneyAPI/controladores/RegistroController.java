package com.alkemy.disneyAPI.controladores;

import com.alkemy.disneyAPI.entidades.Registro;
import com.alkemy.disneyAPI.servicios.RegistroServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "auth/register")
@AllArgsConstructor
public class RegistroController {
    private final RegistroServicio registroServicio;
    
    @PostMapping
    public String register(@RequestBody Registro registro) {
        return registroServicio.registro(registro);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registroServicio.confirmarToken(token);
    }
}
