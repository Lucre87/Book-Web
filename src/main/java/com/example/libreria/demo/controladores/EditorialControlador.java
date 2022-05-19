/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.libreria.demo.controladores;

import com.example.libreria.demo.entidades.Editorial;
import com.example.libreria.demo.servicios.EditorialServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editoriales")/*con esta anotacion cada controlador responde a una
ruta especifica y a una instrucción especifica-debe especificar a que peticion responder POST/GET etc*/
public class EditorialControlador {
  

   @Autowired
   EditorialServicio editorialServicio;
    
    @GetMapping("/guardarEditorial")
    public String guardarEditorial(){
        return "Editoriales";
    
}
    
    @PostMapping("/guardarEditorial")
    public String guardarEditorial(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            editorialServicio.guardarEditorial("Editorial", nombre);
            System.out.println("Editorial " + nombre);
            modelo.addAttribute("exito", "Editorial ingresada con éxito!!");
        } catch (Exception e) {
            e.getMessage();
            modelo.addAttribute("error", "No se ha podido guardar la editorial");
        }
        return "Editoriales";
    }

    @GetMapping("/listarEditoriales")
    public String listarEditoriales(ModelMap modelo) {
        List<Editorial> editorial = editorialServicio.listarEditorial();
        modelo.addAttribute("editoriales", editorial);
        return "Editoriales";
    }

}  
