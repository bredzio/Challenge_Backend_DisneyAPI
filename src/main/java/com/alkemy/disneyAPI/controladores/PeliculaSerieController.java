package com.alkemy.disneyAPI.controladores;

import com.alkemy.disneyAPI.entidades.PeliculaSerie;
import com.alkemy.disneyAPI.servicios.GeneroServicio;
import com.alkemy.disneyAPI.servicios.PeliculaSerieServicio;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/peliculas")
public class PeliculaSerieController {
    
    @Autowired
    private PeliculaSerieServicio peliculaServicio;
    
    @Autowired
    private GeneroServicio generoServicio;
    
    @GetMapping()
    public Iterable<Object[]> obtenerListaPeliculaSeries(){
        return peliculaServicio.obtenerPeliculasYSeries();
    }
    
    @GetMapping("/{id}")
    public Optional<PeliculaSerie> findById(@PathVariable("id") Integer id){
        return peliculaServicio.findById(id);
    }
    
    @GetMapping(params="nombre")
    public Iterable<Object[]> findByTitulo(@RequestParam("nombre") String titulo){
        return peliculaServicio.findByTitulo(titulo);
    }
    
    @GetMapping(params="orden")
    public Iterable<Object[]> getByOrder(@RequestParam("orden") String orden){
        return peliculaServicio.obtenerPorOrden(orden);
    }
    
    @GetMapping(value = "", params="generoId")
    public List<PeliculaSerie> getBygenero(@RequestParam("generoId") Integer generoId){
        return generoServicio.obtenerPeliculasPorGenero(generoId);
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        try {
            peliculaServicio.eliminar(id);
            return "Personaje número "+id+" eliminado";
        } catch (Exception e) {
            return "Personaje número "+id+" no pudo ser eliminado";
        }
    }
    
    @PostMapping("save")
    public PeliculaSerie save(@RequestParam("file") MultipartFile image, @ModelAttribute PeliculaSerie peliculaSerie){
        if(!image.isEmpty()){
            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                peliculaSerie.setImagen(image.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return peliculaServicio.guardarPeliculaSerie(peliculaSerie);
    }
    
}
