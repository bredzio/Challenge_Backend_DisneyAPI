package com.alkemy.disneyAPI.repositorios;

import com.alkemy.disneyAPI.entidades.PeliculaSerie;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaSerieRepositorio extends JpaRepository<PeliculaSerie, Integer>{
    public Iterable<Object[]> findByTitulo(String titulo);
    
    public Optional<PeliculaSerie> findById(Integer id);
    
    public PeliculaSerie getById(Integer peliculaId);
    
    @Query("SELECT titulo, imagen, fechaCreacion FROM PeliculaSerie")
    public Iterable<Object[]> obtenerPeliculasYSeries();
    
    @Query("SELECT titulo, imagen, fechaCreacion FROM PeliculaSerie ORDER BY fechaCreacion ASC")
    public Iterable <Object[]> obtenerListaOrdenadaASC();
    
    @Query("SELECT titulo, imagen, fechaCreacion FROM PeliculaSerie ORDER BY fechaCreacion DESC")
    public Iterable<Object[]> obtenerListaOrdenadaDESC();
}
