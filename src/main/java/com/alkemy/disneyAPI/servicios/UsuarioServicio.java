package com.alkemy.disneyAPI.servicios;

import com.alkemy.disneyAPI.entidades.Usuario;
import com.alkemy.disneyAPI.repositorios.UsuarioRepositorio;
import com.alkemy.disneyAPI.seguridad.token.TokenConfirmacion;
import com.alkemy.disneyAPI.seguridad.token.TokenConfirmacionServicio;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServicio implements UserDetailsService{
    
    private final static String usuarioNoEncontrado = "No se encontró usuario con ese email %s";

    private final UsuarioRepositorio usuarioRepositorio;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenConfirmacionServicio tokenConfirmacionServicio;
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return usuarioRepositorio.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(usuarioNoEncontrado, email)));    }
    
    public String altaUsuario(Usuario usuario) {
        boolean existenciaUsuario = usuarioRepositorio.findByEmail(usuario.getEmail()).isPresent();

        if (existenciaUsuario) {
            throw new IllegalStateException("Email ok");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(usuario.getPassword());

        usuario.setPassword(encodedPassword);

        usuarioRepositorio.save(usuario);

        String token = UUID.randomUUID().toString();

        TokenConfirmacion tokenConfirmacion = new TokenConfirmacion(token,LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),usuario);
        
        tokenConfirmacionServicio.guardarConfirmacionToken(tokenConfirmacion);

        return token;
    }
    
    public int enableAppUser(String email) {
        return usuarioRepositorio.enableAppUser(email);
    }
}
