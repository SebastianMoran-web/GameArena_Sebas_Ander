package com.example.GameArena.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "videojuego")
    @JsonIgnore
    private List<Torneo> torneos;

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
