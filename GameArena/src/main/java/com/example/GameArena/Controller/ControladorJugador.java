package com.example.GameArena.Controller;

import com.example.GameArena.Modelos.Jugador;
import com.example.GameArena.Servicios.ServiciosJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")

public class ControladorJugador {

    @Autowired
    private ServiciosJugador serviciosJugador;

    @GetMapping
    public List<Jugador> getJugadores(){

        return serviciosJugador.obtenerTodos();
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador){

        return serviciosJugador.guardar(jugador);
    }

    @GetMapping("/{id}")
    public Jugador getJugador(@PathVariable Long id){

        return serviciosJugador.buscarPorId(id);

    }

    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        serviciosJugador.borrarPorId(id);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugador){

        jugador.setId(id);
        return serviciosJugador.modificarJugador(jugador);

    }



}
