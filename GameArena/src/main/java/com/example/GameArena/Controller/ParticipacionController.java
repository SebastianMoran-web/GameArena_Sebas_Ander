package com.example.GameArena.Controller;


import com.example.GameArena.Modelos.Participacion;
import com.example.GameArena.Modelos.Videojuego;
import org.springframework.http.ResponseEntity;
import com.example.GameArena.Servicios.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participacion") // o el endpoint que corresponda
@CrossOrigin(origins = "*") // Para desarrollo, permite cualquier origen
public class ParticipacionController {

    @Autowired
    private ParticipacionService participacionService;

    //  Inscribir a un jugador en un torneo
    @PostMapping
    public ResponseEntity<Participacion> inscribir(@RequestBody Participacion participacion) {
        return ResponseEntity.ok(participacionService.guardar(participacion));
    }

    //  Listar todas las participaciones
    @GetMapping
    public ResponseEntity<List<Participacion>> listarTodas() {
        return ResponseEntity.ok(participacionService.obtenerTodas());
    }

    //  Consultar torneos/participaciones de un jugador
    @GetMapping("/jugador/{jugadorId}")
    public ResponseEntity<List<Participacion>> obtenerPorJugador(@PathVariable Long jugadorId) {
        return ResponseEntity.ok(participacionService.obtenerPorJugador(jugadorId));
    }

    //  Consultar participantes de un torneo
    @GetMapping("/torneo/{torneoId}")
    public ResponseEntity<List<Participacion>> obtenerPorTorneo(@PathVariable Long torneoId) {
        return ResponseEntity.ok(participacionService.obtenerPorTorneo(torneoId));
    }
}
