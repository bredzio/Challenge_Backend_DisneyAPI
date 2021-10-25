package com.alkemy.disneyAPI.controladores;

import com.alkemy.disneyAPI.entidades.Personaje;
import com.alkemy.disneyAPI.servicios.PersonajeServicio;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
@RequestMapping("/personajes")
public class PersonajeController {
    
    @Autowired
    private PersonajeServicio personajeServicio;
    
    @GetMapping()
    public Iterable<Object[]> getAll(){
        return personajeServicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Personaje> findById(@PathVariable("id") Integer personajeId){
        return personajeServicio.findById(personajeId); 
    }
    
    @GetMapping(params="nombre")
    public Iterable<Object[]> findByNombre(@RequestParam("nombre") String nombre){
        return personajeServicio.findByNombre(nombre);
    }
    
    @GetMapping(params="edad")
    public Iterable<Object[]> findByEdad(@RequestParam("edad") Integer edad){
        return personajeServicio.findByEdad(edad);
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            personajeServicio.eliminarPersonaje(id);
            return "Personaje número "+id+" eliminado.";
        } catch (Exception e) {
            return "Personaje número "+id+" no pudo ser eliminado.";
        }
    }
    
    @PostMapping("save")
    public Personaje save(@RequestParam("file") MultipartFile image, @ModelAttribute Personaje personaje){
        if(!image.isEmpty()){
            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                personaje.setImagen(image.getOriginalFilename());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return personajeServicio.guardarPersonaje(personaje);
    }
}
