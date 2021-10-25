package com.alkemy.disneyAPI.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PeliculaSerie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer peliculaID;
    private String titulo;
    private String imagen;
    private Integer calificacion;
    @JsonFormat(pattern="dd/mm/yyyy")
    private Date fechaCreacion;
    
    @ManyToMany(mappedBy="peliculasID")
    private List<Personaje> personajesID;
    
    @ManyToOne
    @JoinColumn(name="generoID")
    private Genero generosID;
}
