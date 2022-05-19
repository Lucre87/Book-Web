package com.example.libreria.demo.repositorios;

import com.example.libreria.demo.entidades.Libro;
import java.util.List;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {
    
    @Query ("SELECT c from Libro c WHERE c.isbn= :isbn")
    public Libro buscarPorISBN (@Param ("isbn") Long isbn);

   /* @Query("SELECT c from Libro c WHERE c.Titulo Like % :Titulo%")
    public List <Libro> buscarPorTitulo(@Param("Titulo") String Titulo);

    @Query("SELECT c from Libro c WHERE c.Autor.nombre= :nombre")
    public List <Libro> buscarPorAutor(@Param("nombre") String Autor);
    
    @Query("SELECT c from Libro c WHERE c.editorial.nombre= :nombre")
    public List <Libro> buscarPorEditorial(@Param("nombre") String nombre);*/
    
    
    
    
}
