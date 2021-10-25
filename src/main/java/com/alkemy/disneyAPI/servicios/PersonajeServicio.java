package com.alkemy.disneyAPI.servicios;

import com.alkemy.disneyAPI.entidades.Personaje;
import com.alkemy.disneyAPI.repositorios.PersonajeRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonajeServicio {
    
    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    
    @Transactional
    public Personaje guardarPersonaje(Personaje personaje){
        personajeRepositorio.save(personaje);
        return personaje;
    }
    
    @Transactional
    public void eliminarPersonaje(Integer id){
        try{
            personajeRepositorio.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    @Transactional
    public Iterable<Personaje> encontrarPersonajes(){
        return personajeRepositorio.findAll();
    }
    
    @Transactional
    public Iterable<Object[]> getAll(){
        return personajeRepositorio.obtenerTodosLosPersonajes();
    }
    
    @Transactional
    public Optional<Personaje> findById(Integer personajeId){
        return personajeRepositorio.findById(personajeId);
    }
    
    @Transactional
    public Iterable<Object[]> findByNombre(String nombre){
        return personajeRepositorio.findByNombre(nombre);
    }
    
    @Transactional
    public Iterable<Object[]> findByEdad(Integer edad){
        return personajeRepositorio.findByEdad(edad);
    }
}
