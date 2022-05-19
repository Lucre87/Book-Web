
package com.example.libreria.demo.controladores;

import com.example.libreria.demo.servicios.AutorServicio;
import com.example.libreria.demo.servicios.EditorialServicio;
import com.example.libreria.demo.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // tengamos controladores que nos devuelven nuestras vistas principales
public class PortalControlador {
   @Autowired
   private AutorServicio autorServicio;
     @Autowired
    private EditorialServicio editorialServicio;
      @Autowired
    private LibroServicio libroServicio;
      
      @GetMapping("")
    
        public String index() {
       
        return "index.html";
    }
     @GetMapping("/Autores")
    public String admAutor() {
        return "Autores";
    
    }
    @GetMapping("/Editoriales")
    public String admEditorial() {
        return "Editoriales";
    }

    @GetMapping("admLibros")
    public String admLibro() {
        return "admLibros";
    }

}

   
