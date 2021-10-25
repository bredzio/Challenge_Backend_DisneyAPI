package com.alkemy.disneyAPI.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Genero {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer generoID;
    private String nombre;
    private String imagen;
    
    @OneToMany(mappedBy="generosID")
    private List<PeliculaSerie> peliculasID;
}
