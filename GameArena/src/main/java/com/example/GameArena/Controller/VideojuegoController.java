package com.example.GameArena.Controller;

import com.example.GameArena.Modelos.Videojuego;
import com.example.GameArena.Servicios.VideojuegoService; // Corregido a 'Servicios'
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> getVideojuegos() {
        return videojuegoService.obtenerTodos();
    }

    @PostMapping
    public Videojuego createVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoService.guardar(videojuego);
    }
}
