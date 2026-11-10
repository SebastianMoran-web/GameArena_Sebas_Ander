package com.example.GameArena.controlador;

import com.example.GameArena.Modelos.Torneo;
import com.example.GameArena.Servicios.ServiciosTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/torneo")

public class ControladorTorneo {

    @Autowired
    private ServiciosTorneo serviceTorneo;

    @GetMapping
    public List<Torneo> getTorneos(){

        return serviceTorneo.obtenerTodos();
    }

    @PostMapping
    public Torneo createTorneo(@RequestBody Torneo torneo){

        return serviceTorneo.guardar(torneo);
    }

    @GetMapping("/{id}")
    public Torneo getTorneo(@PathVariable Long id){

        return serviceTorneo.buscarPorId(id);

    }

    @DeleteMapping("/{id}")
    public void eliminarTorneo(@PathVariable Long id) {
        serviceTorneo.borrarPorId(id);
    }

    @PutMapping("/{id}")
    public Torneo updateTorneo(@PathVariable Long id, @RequestBody Torneo torneo){

        torneo.setId(id);
        return serviceTorneo.modificarTorneo(torneo);

    }

    @GetMapping("/estado/{estado}")
    public List<Torneo> getTorneosByEstado(@PathVariable String estado){
        return serviceTorneo.buscarPorEstado(estado);
    }

    @GetMapping("/videojuego/{id}")
    public List<Torneo> getTorneoPorVideojuego(@PathVariable Long id){
        return serviceTorneo.buscarPorVideojuegoID(id);
    }

    @GetMapping("/videojuego/{id}/estado/{estado}")
    public List<Torneo> getTorneosPorEstadoYEstado(@PathVariable Long id, @PathVariable String estado){
        return serviceTorneo.buscarPorVideojuegoIdAndEstado(id, estado);
    }



}