package com.alkemy.disneyAPI.repositorios;

import com.alkemy.disneyAPI.entidades.Personaje;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje,Integer> {
    
    public Iterable<Object[]> findByNombre(String nombre);
    public Iterable<Object[]> findByEdad(Integer edad);
    public List<Object[]> findByPeliculasID(String pelicula);
    
    @Query("SELECT nombre, imagen FROM Personaje")
    public Iterable<Object[]> obtenerTodosLosPersonajes();
    
    
}
