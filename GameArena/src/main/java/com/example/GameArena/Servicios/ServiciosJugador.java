package com.example.GameArena.Servicios;

import com.example.GameArena.Modelos.Jugador;
import com.example.GameArena.Repositorios.RepositorioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiciosJugador {

    @Autowired
    private RepositorioJugador repositorioJugador;

    public List<Jugador> obtenerTodos() {
        return repositorioJugador.findAll();
    }

    public Jugador guardar(Jugador jugador) {
        return repositorioJugador.save(jugador);
    }

    public Jugador buscarPorId(Long id) {

        return repositorioJugador.findById(id).orElse(null);

    }

    public void borrarPorId(Long id) {
        repositorioJugador.deleteById(id);
    }

    public Jugador modificarJugador(Jugador jugador) {
        return repositorioJugador.save(jugador);
    }

    public List<Participacion> obtenerParticipaciones(Long id) {

        Jugador jugador = repositorioJugador.findById(id).orElse(null);

        if (jugador != null) {
            return jugador.getParticipaciones();
        }

        return null;
    }
}