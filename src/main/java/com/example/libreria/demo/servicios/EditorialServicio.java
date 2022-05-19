package com.example.libreria.demo.servicios;

import com.example.libreria.demo.entidades.Autor;
import com.example.libreria.demo.entidades.Editorial;
import com.example.libreria.demo.errores.errorServicio;
import com.example.libreria.demo.repositorios.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio EditorialRepositorio;
    @Transactional
    public void guardarEditorial(String Id, String Nombre) throws errorServicio {

        if (Id == null || Id.isEmpty()) {
            throw new errorServicio("El Id no puede estar vacío");
        }
        validar(Nombre);
        Optional<Editorial> respuesta = EditorialRepositorio.findById(Id);
        Editorial editorial = respuesta.get();
        if (respuesta.isPresent()) {

            editorial.setAlta(true);
        } else {

            editorial.setId(Id);
            editorial.setNombre(Nombre);
            editorial.setAlta(true);

        }
        EditorialRepositorio.save(editorial);
    }
    @Transactional
    public void modificarEditorial(String Id, String Nombre) throws errorServicio {

        if (Id == null || Id.isEmpty()) {
            throw new errorServicio("El Id no puede estar vacío");
        }
        validar(Nombre);
        Optional<Editorial> respuesta = EditorialRepositorio.findById(Id);
        Editorial editorial = respuesta.get();
        if (respuesta.isPresent()) {

            editorial.setId(Id);
            editorial.setNombre(Nombre);
            editorial.setAlta(true);

        }
        EditorialRepositorio.save(editorial);
    }
    @Transactional
    public void bajaEditorial(String Id) throws errorServicio {

        if (Id == null || Id.isEmpty()) {
            throw new errorServicio("El Id no puede estar vacío");
        }

        Optional<Editorial> respuesta = EditorialRepositorio.findById(Id);
        Editorial editorial = respuesta.get();
        if (respuesta.isPresent()) {

            editorial.setAlta(false);

        }
        EditorialRepositorio.save(editorial);
    }
    
    public void buscarEditorialporId(String Id){
        
        Optional<Editorial> respuesta = EditorialRepositorio.findById(Id);
        Editorial editorial = respuesta.get();
        
}
    public List <Editorial> listarEditorial (){
        List<Editorial>editoriales= EditorialRepositorio.findAll();
         return
             editoriales;  
            
        }
    
    public void validar(String nombre)throws errorServicio{
        if (nombre== null||nombre.trim().isEmpty())
            throw new errorServicio("El nombre no puede estar vacío");
        }
        
    }


