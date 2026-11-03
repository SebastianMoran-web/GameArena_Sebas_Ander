package com.example.GameArena.Modelos;

import jakarta.persistence.*;


@Entity // Indica que esta clase se debe mapear como una tabla en la base de datos
@Table(name = "videojuegos") // Define el nombre exacto de la tabla en H2
public class Videojuego {

    //  ATRIBUTOS
    // Marca este atributo como la clave primaria (Primary Key) de la tabla
    @Id
    // Configura el autoincremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String genero;


    //  CONSTRUCTORES

    /**
     * Constructor sin argumentos.
     * Para poder instanciar la entidad al recuperar datos.
     */
    public Videojuego() {
    }

    /**
     * Constructor con parámetros (sin ID, ya que el ID lo genera la base de datos).
     * Facilita la creación de objetos desde el Service o los tests.
     */
    public Videojuego(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }


    //  GETTERS Y SETTERS
    // Convierten la entidad a JSON

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
