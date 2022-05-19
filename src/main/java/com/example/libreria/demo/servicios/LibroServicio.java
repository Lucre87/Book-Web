
package com.example.libreria.demo.servicios;

import com.example.libreria.demo.entidades.Autor;
import com.example.libreria.demo.entidades.Editorial;
import com.example.libreria.demo.entidades.Libro;
import com.example.libreria.demo.errores.errorServicio;
import com.example.libreria.demo.repositorios.AutorRepositorio;
import com.example.libreria.demo.repositorios.EditorialRepositorio;
import com.example.libreria.demo.repositorios.LibroRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 @Service
public class LibroServicio {
     @Autowired
     private LibroRepositorio libroRepositorio;
     @Autowired
      private AutorRepositorio autorRepositorio;
     @Autowired
     private EditorialRepositorio editorialRepositorio;
     
     
     
    /*1. METODO PARA REGISTRAR LOS LIBROS QUE INGRESAN A LA LIBRERIA*/
    @Transactional
    public void guardarLibro (Long isbn, String Titulo, Integer anio, Autor autor, Editorial editorial)throws errorServicio{
        /*Antes de persistir el objeto tenemos que validar que los atributos lleguen*/
        validar(isbn,Titulo,autor,editorial,anio);        
        
        //Creamos un nuevo libro y le seteamos los datos
        Libro libro= new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(Titulo);
        libro.setAnio(anio);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setAlta(true);
        libroRepositorio.save(libro);//el repositorio guarda el objeto creado en la base de datos, lo transforma en una tabla
}   @Transactional
    public void darDeBaja (String Id)throws errorServicio{
        if (Id==null||Id.isEmpty()){
            throw new errorServicio("Debe ingresar el ID del libro");
        }
        Optional <Libro> respuesta= libroRepositorio.findById(Id);
         if(respuesta.isPresent()){
        Libro libro = respuesta.get();
        libro.setAlta(false);
        libroRepositorio.save(libro);
        
        
 }
         
    }
    public void modificar (String Id,Long isbn, String Titulo, Integer anio, Editorial editorial, Autor autor)throws errorServicio{
        validar(isbn,Titulo,autor,editorial,anio); 
        
        Optional <Libro> respuesta= libroRepositorio.findById(Id);
         if(respuesta.isPresent()){
        Libro libro = respuesta.get();
        libro.setIsbn(isbn);
        libro.setTitulo(Titulo);
        libro.setAnio(anio);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        libroRepositorio.save(libro);
        
         }
    }
    
    public List <Libro> listarLibros (){
        List<Libro> libros=  libroRepositorio.findAll();
        
            return libros;
        }
        
        
        
    
         /*VER COMO SE PUEDE HACER
         public Integer calcularEjemplares (Integer ejemplares, Integer ejemplaresPrestados){
             Integer ejemplaresRestantes= ejemplares - ejemplaresPrestados;
             return ejemplaresRestantes;
             
         }*/
    
/*
    public List <Libro> buscarPorTitulo (String Titulo) throws errorServicio{
        if (Titulo==null||Titulo.isEmpty()){
        throw new errorServicio ("El título no puede estar vacío");}
        List <Libro> libro = libroRepositorio.buscarPorTitulo(Titulo);
            return libro;
        
        
    
 }
    public List <Libro> buscarPorAutor (String Autor) throws errorServicio{        
        if (Autor==null||Autor.isEmpty()){
            throw new errorServicio ("Debe indicar el nombre del autor");}
            List <Libro> libro = libroRepositorio.buscarPorAutor(Autor);
            return libro;
 }
    
    
    
    public List <Libro> buscarPorEditorial (String Editorial) throws errorServicio{
        
        if (Editorial==null||Editorial.isEmpty()){
            throw new errorServicio ("Debe indicar nombre de editorial");}
        
            List <Libro> libro = libroRepositorio.buscarPorEditorial(Editorial);
            return libro;
 }

     
    */
    
    
     public Libro buscarISBN (Long isbn) throws errorServicio{
       
        if (isbn==null){
            throw new errorServicio ("Debe indicar ISBN");}
         Libro Libro = libroRepositorio.buscarPorISBN(isbn);
            return Libro;
 }
    
    
    
    public void validar(Long isbn, String Titulo, Autor autor, Editorial editorial, Integer anio)throws errorServicio{
       
        if (isbn<0){
            throw new errorServicio("ISBN debe ser mayor a 0");}
        if (Titulo== null||Titulo.trim().isEmpty()){
            throw new errorServicio("El titulo no puede estar vacío");}
        if (autor== null){
            throw new errorServicio("El autor no puede estar vacío");}
        if (editorial== null){
            throw new errorServicio("La editorial no puede estar vacía");}
        if (anio==null){
            throw new errorServicio ("Debe ingresar año del libro");
    }
 }

    

   
 }