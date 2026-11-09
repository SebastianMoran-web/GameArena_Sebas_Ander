package com.example.GameArena.Controller;

import com.example.GameArena.Modelos.Jugador;
import com.example.GameArena.Servicio.ServicioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")

public class ControladorJugador {

    @Autowired
    private ServicioJugador servicioJugador;

    @GetMapping
    public List<Jugador> getJugadores(){

        return servicioJugador.obtenerTodos();
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador){

        return servicioJugador.guardar(jugador);
    }

    @GetMapping("/{id}")
    public Jugador getJugador(@PathVariable Long id){

        return servicioJugador.buscarPorId(id);

    }

    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        servicioJugador.borrarPorId(id);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugador){

        jugador.setId(id);
        return servicioJugador.modificarJugador(jugador);

    }



}
