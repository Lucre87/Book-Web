
package com.example.libreria.demo.repositorios;


import com.example.libreria.demo.entidades.Editorial;
import com.example.libreria.demo.entidades.Libro;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
    
    @Query ("SELECT e FROM Editorial e WHERE e.nombre= :nombre")
      public Editorial buscarPorNombre (@Param ("nombre") String nombre);
    
}
