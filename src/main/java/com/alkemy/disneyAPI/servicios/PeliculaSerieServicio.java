package com.alkemy.disneyAPI.servicios;

import com.alkemy.disneyAPI.entidades.PeliculaSerie;
import com.alkemy.disneyAPI.repositorios.PeliculaSerieRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaSerieServicio {
    
    @Autowired
    private PeliculaSerieRepositorio peliculaRepositorio;
    
    @Transactional
    public Iterable<PeliculaSerie> findAll(){
        return peliculaRepositorio.findAll();
    }
    
    @Transactional
    public Iterable<Object[]> obtenerPeliculasYSeries(){
        return peliculaRepositorio.obtenerPeliculasYSeries();
    }
    
    @Transactional
    public Optional<PeliculaSerie> findById(Integer id){
        return peliculaRepositorio.findById(id);
    }
    
    @Transactional
    public PeliculaSerie guardarPeliculaSerie(PeliculaSerie peliculaSerie){
        return peliculaRepositorio.save(peliculaSerie);
    }
    
    @Transactional
    public Iterable<Object[]> findByTitulo(String titulo){
        return peliculaRepositorio.findByTitulo(titulo);
    }
    
    @Transactional
    public void eliminar(Integer id){
        try{
            peliculaRepositorio.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
        }    
    }
    
    @Transactional
    public Iterable<Object[]> obtenerPorOrden(String order){
        if(order.equals("ASC")){
            return peliculaRepositorio.obtenerListaOrdenadaASC();
        }else if(order.equals("DESC")){
            return peliculaRepositorio.obtenerListaOrdenadaDESC();
        }else{
            return peliculaRepositorio.obtenerPeliculasYSeries();
        }
    }
    
   
  
}
