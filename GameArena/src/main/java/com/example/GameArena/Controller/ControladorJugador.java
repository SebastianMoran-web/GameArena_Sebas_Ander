package com.example.GameArena.Controller;

import com.example.GameArena.Modelos.Jugador;
import com.example.GameArena.Servicios.ServiceJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jugadores") // o el endpoint que corresponda
@CrossOrigin(origins = "*") // Para desarrollo, permite cualquier origen
public class ControladorJugador {

    @Autowired
    private ServiceJugador serviceJugador;

    @GetMapping
    public List<Jugador> getJugadores(){

        return serviceJugador.obtenerTodos();
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador){

        return serviceJugador.guardar(jugador);
    }

    @GetMapping("/{id}")
    public Jugador getJugador(@PathVariable Long id){

        return serviceJugador.buscarPorId(id);

    }

    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        serviceJugador.borrarPorId(id);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugador){

        jugador.setId(id);
        return serviceJugador.modificarJugador(jugador);

    }



}
