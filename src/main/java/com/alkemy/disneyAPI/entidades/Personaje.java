package com.alkemy.disneyAPI.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Personaje {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer personajeID;
    private String nombre;
    private String imagen;
    private Integer edad;
    private Integer peso;
    private String historia;
    
    @ManyToMany
    @JoinTable(name = "personajes_por_peliculas",
            joinColumns={
                @JoinColumn(name="personajeID")},
            inverseJoinColumns={
                @JoinColumn(name="peliculaID")})
    private List<PeliculaSerie> peliculasID;
    
}
