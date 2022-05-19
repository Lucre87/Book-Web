package com.example.libreria.demo.servicios;

import com.example.libreria.demo.entidades.Autor;
import com.example.libreria.demo.errores.errorServicio;
import com.example.libreria.demo.repositorios.AutorRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio AutorRepositorio;
    @Transactional
    public Autor guardarAutor(String Nombre) throws errorServicio {
        
        validar(Nombre);
        Autor autor = new Autor();
        
            autor.setAlta(true);       

            autor.setNombre(Nombre);
            
            return
        
           AutorRepositorio.save(autor);
    }
    
    @Transactional
    public void modificarAutor(String Id, String Nombre) throws errorServicio {
        if (Id == null || Id.isEmpty()) {
            throw new errorServicio("El Id no puede estar vacío");
        }
        validar(Nombre);
        Optional<Autor> respuesta = AutorRepositorio.findById(Id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(Nombre);
            autor.setAlta(true);
            AutorRepositorio.save(autor);
        }

    }
    @Transactional
    public void darDeBajaAutor(String Id) throws errorServicio {
        if (Id == null || Id.isEmpty()) {
            throw new errorServicio("El Id no puede estar vacío");
        }

        Optional<Autor> respuesta = AutorRepositorio.findById(Id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setAlta(false);
            AutorRepositorio.save(autor);
        }
    }
    /*METODO buscar por ID*/
    public void buscarAutorPorId(String Id){
        
        Optional<Autor> respuesta = AutorRepositorio.findById(Id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setAlta(false);
            AutorRepositorio.save(autor);
    }
    }   
     public Autor buscarAutorPorNombre(String nombre) throws errorServicio{
        validar(nombre);
        
        Autor autor = AutorRepositorio.buscarPorNombre(nombre);
            return autor;
    }
      
    
    public List <Autor> listarAutor (){
        List<Autor>autores= AutorRepositorio.findAll();
         return
             autores;    
              
        }
    public void validar(String nombre)throws errorServicio{
        if (nombre== null||nombre.trim().isEmpty())
            throw new errorServicio("El nombre no puede estar vacío");
        }
        
    }
       
    
