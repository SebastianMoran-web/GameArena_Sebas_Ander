package com.example.GameArena.Repositorios;

import com.example.GameArena.Modelos.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioTorneo  extends JpaRepository<Torneo,Long>{

    List<Torneo> findByEstado(String estado);
    List<Torneo> findByVideojuegoId(Long id);
    List<Torneo> findByVideojuegoIdAndEstado(Long id,String estado);

}
