package com.example.GameArena.Repositorios;

import com.example.GameArena.Modelos.Participacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParticipacionRepository extends JpaRepository<Participacion, Long> {

    // Buscar participaciones filtrando por la relación jugador y su atributo id
    List<Participacion> findByJugadorId(Long jugadorId);

    // Buscar participaciones filtrando por la relación torneo y su atributo id
    List<Participacion> findByTorneoId(Long torneoId);
}