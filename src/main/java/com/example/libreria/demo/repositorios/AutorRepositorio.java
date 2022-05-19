
package com.example.libreria.demo.repositorios;

import com.example.libreria.demo.entidades.Autor;
import com.example.libreria.demo.entidades.Libro;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


  @Repository
 
public interface AutorRepositorio extends JpaRepository<Autor, String> {
     
      @Query ("SELECT a FROM Autor a WHERE a.nombre= :nombre")
      public Autor buscarPorNombre (@Param ("nombre") String nombre);
      
      
}
