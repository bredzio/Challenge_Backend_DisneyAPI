package com.alkemy.disneyAPI.servicios;

import com.alkemy.disneyAPI.entidades.Genero;
import com.alkemy.disneyAPI.entidades.PeliculaSerie;
import com.alkemy.disneyAPI.repositorios.GeneroRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServicio {
    
    @Autowired
    private GeneroRepositorio generoRepositorio;
    
    @Transactional
    public void crearGenero(Genero genero){
        generoRepositorio.save(genero);
    }
    
    @Transactional
    public void eliminarGenero(Integer id){
        try{
            generoRepositorio.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    @Transactional
    public Optional<Genero> findById(Integer generoId){
        return generoRepositorio.findById(generoId);
    }
    
    @Transactional
    public List<PeliculaSerie> obtenerPeliculasPorGenero(Integer generoId){
        Genero genero = generoRepositorio.getById(generoId);
        if(genero != null){
            List<PeliculaSerie> peliculasSeries = genero.getPeliculasID();
            return peliculasSeries;
        }else{
            return null;
        }
        
    }
}
