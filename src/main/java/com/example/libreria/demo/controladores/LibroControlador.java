

package com.example.libreria.demo.controladores;

import com.example.libreria.demo.entidades.Autor;
import com.example.libreria.demo.entidades.Editorial;
import com.example.libreria.demo.entidades.Libro;
import com.example.libreria.demo.servicios.AutorServicio;
import com.example.libreria.demo.servicios.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Libros")
public class LibroControlador {
    @Autowired
    LibroServicio libroServicio;
    
    @GetMapping("/guardarLibro")
    public String guardarLibro(){
        return "guardarLibro";
    
}
    
    @PostMapping("/guardarLibro")
    public String guardarLibro(ModelMap modelo, @RequestParam  Long isbn,@RequestParam String Titulo, @RequestParam Integer anio, @RequestParam Autor autor,@RequestParam Editorial editorial) throws Exception {
        try {
            libroServicio.guardarLibro(isbn, Titulo, anio, autor, editorial);
            System.out.println("Libro " + Titulo);
            modelo.put("exito", "Libro ingresado con éxito!!");
        } catch (Exception e) {
            e.getMessage();
            modelo.put("error", "No se ha podido guardar el Libro");
        }
        return "Libros";
    }
          
   

    @GetMapping("/mostrarLibros")
    public String mostrarLibros(ModelMap modelo) {
        List<Libro> libros = libroServicio.listarLibros();
        modelo.addAttribute("libro", libros);
        return "Libros";
    }

}
    
    

