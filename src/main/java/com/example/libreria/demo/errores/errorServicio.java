
package com.example.libreria.demo.errores;

/*se crea la clase error servicio para diferenciar los errores de la logica de 
negocio de los errores que ocurren en sistema*/
public class errorServicio extends Exception {
    public errorServicio (String msn){
        super(msn);
    }
}
