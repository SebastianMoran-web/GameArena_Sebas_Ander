package com.example.GameArena.Servicios;

import com.example.GameArena.Modelos.Torneo;
import com.example.GameArena.Repositorio.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiciosTorneo {

    @Autowired
    private RepositorioTorneo repositorioTorneo;

    public List<Torneo> obtenerTodos() {
        return repositorioTorneo.findAll();
    }

    public Torneo guardar(Torneo torneo) {
        return repositorioTorneo.save(torneo);
    }

    public Torneo buscarPorId(Long id) {

        return repositorioTorneo.findById(id).orElse(null);

    }

    public void borrarPorId(Long id) {
        repositorioTorneo.deleteById(id);
    }

    public Torneo modificarTorneo(Torneo torneo) {
        return repositorioTorneo.save(torneo);
    }

    public List<Torneo> buscarPorEstado(String estado) {
        return repositorioTorneo.findByEstado(estado);
    }

    public List<Torneo> buscarPorVideojuegoID(Long videojuego_Id) {
        return repositorioTorneo.findByVideojuegoId(videojuego_Id);
    }

    public List<Torneo> buscarPorVideojuegoIdAndEstado(Long videojuegoId, String estado) {
        return repositorioTorneo.findByVideojuegoIdAndEstado(videojuegoId, estado);
    }
}