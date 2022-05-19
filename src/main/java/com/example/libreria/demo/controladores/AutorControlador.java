
package com.example.libreria.demo.controladores;

import com.example.libreria.demo.entidades.Autor;
import com.example.libreria.demo.servicios.AutorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autores")/*con esta anotacion cada controlador responde a una
ruta especifica y a una instrucción especifica-debe especificar a que peticion responder POST/GET etc*/
public class AutorControlador {
    @Autowired
    AutorServicio autorServicio;
    
    @GetMapping("/guardarAutor")
    public String guardarAutor(){
        return "Autores";
    
}
    // Con este método vamos a recolectar información de nuestros HTML
    // utilizando el RequestParam los vamos a extraer.
    // si no se puede realizar la instruccion (persistir un autor)
    // debemos manejar esa excepción para que no se caiga la página
    @PostMapping("/guardarAutor")
    public String guardarAutor(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            autorServicio.guardarAutor(nombre);
            System.out.println("Autor " + nombre);
           modelo.addAttribute("exito", "Autor ingresado con éxito!!");
        } catch (Exception e) {
            e.getMessage();
           modelo.addAttribute("error", "No se ha podido guardar el autor");
        }
        return "Autores";
    }

    @GetMapping("/mostrarAutores")
    public String mostrarAutores(ModelMap modelo) {
        List<Autor> autores = autorServicio.listarAutor();
        modelo.addAttribute("autor", autores);
        return "Autores";
    }

}