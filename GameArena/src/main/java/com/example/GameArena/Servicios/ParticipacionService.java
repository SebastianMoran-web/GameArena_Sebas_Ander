package com.example.GameArena.Servicios;


import com.example.GameArena.Modelos.Participacion;
import com.example.GameArena.Repositorios.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipacionService {

    @Autowired
    private ParticipacionRepository participacionRepository;

    // 1 Guardar / Inscribir jugador en torneo
    public Participacion guardar(Participacion participacion) {
        return participacionRepository.save(participacion);
    }

    // 2 Listar todas las participaciones
    public List<Participacion> obtenerTodas() {
        return participacionRepository.findAll();
    }

    // 3 Consultar torneos/participaciones de un jugador concreto
    public List<Participacion> obtenerPorJugador(Long jugadorId) {
        return participacionRepository.findByJugadorId(jugadorId);
    }

    // 4 Consultar participantes de un torneo concreto
    public List<Participacion> obtenerPorTorneo(Long torneoId) {
        return participacionRepository.findByTorneoId(torneoId);
    }
}

