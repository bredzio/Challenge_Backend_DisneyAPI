package com.alkemy.disneyAPI.repositorios;

import com.alkemy.disneyAPI.entidades.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByEmail(String email);
    
    @Transactional
    @Modifying
    @Query("UPDATE Usuario a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
