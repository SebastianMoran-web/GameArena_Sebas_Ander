package com.example.GameArena.Servicios;


import com.example.GameArena.Modelos.Videojuego;
import com.example.GameArena.Repositorios.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Capa de servicio encargada de la lógica de negocio relacionada con la entidad Videojuego.
 * Actúa como intermediario entre el Controller y el Repository.
 */
@Service
public class VideojuegoService {

    // Inyección de dependencias para acceder a los métodos de Spring
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    /**
     * Recupera todos los videojuegos registrados en la base de datos.
     *
     * @return Lista con todos los objetos Videojuego.
     */
    public List<Videojuego> obtenerTodos() {
        return videojuegoRepository.findAll();
    }

    /**
     * Persiste o actualiza una entidad Videojuego en la base de datos.
     *
     * @param videojuego Entidad a guardar.
     * @return El videojuego guardado, incluyendo su ID generado.
     */
    public Videojuego guardar(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }
}