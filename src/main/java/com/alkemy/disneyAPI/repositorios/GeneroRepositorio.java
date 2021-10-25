package com.alkemy.disneyAPI.repositorios;

import com.alkemy.disneyAPI.entidades.Genero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer>{
    public Optional<Genero> findById(Integer id);
    public Genero getById(Integer generoId);
}
