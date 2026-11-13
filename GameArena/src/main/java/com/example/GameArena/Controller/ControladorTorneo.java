package com.example.GameArena.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.GameArena.Modelos.Torneo;
import com.example.GameArena.Modelos.Participacion;
import com.example.GameArena.Servicios.ServiciosTorneo;
import com.example.GameArena.Repositorios.RepositorioTorneo; // <--- AQUí ESTÁ EL CAMBIO CORRECTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/torneos")
@CrossOrigin(origins = "*")
public class ControladorTorneo {

    @Autowired
    private ServiciosTorneo serviceTorneo;

    @Autowired
    private RepositorioTorneo repositorioTorneo; // <--- Usando tu nombre exacto de clase

    @GetMapping("/{id}/participantes")
    public List<Participacion> getParticipantesTorneo(@PathVariable Long id) {
        return repositorioTorneo.findById(id)
                .map(Torneo::getParticipaciones)
                .orElse(java.util.Collections.emptyList());
    }

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

    // Endpoint para actualizar el estado desde el desplegable de la tabla
    @PutMapping("/{id}/estado")
    public ResponseEntity<Torneo> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return repositorioTorneo.findById(id)
                .map(torneo -> {
                    torneo.setEstado(estado);
                    repositorioTorneo.save(torneo);
                    return ResponseEntity.ok(torneo);
                })
                .orElse(ResponseEntity.notFound().build());
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