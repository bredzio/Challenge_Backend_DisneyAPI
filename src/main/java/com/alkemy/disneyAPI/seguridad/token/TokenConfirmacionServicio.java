package com.alkemy.disneyAPI.seguridad.token;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenConfirmacionServicio {
    private final TokenConfirmacionRepositorio tokenConfirmacionRepositorio;
    
    public void guardarConfirmacionToken(TokenConfirmacion token) {
        tokenConfirmacionRepositorio.save(token);
    }

    public Optional<TokenConfirmacion> obtenerToken(String token) {
        return tokenConfirmacionRepositorio.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return tokenConfirmacionRepositorio.updateConfirmedAt(token, LocalDateTime.now());
    }
}
