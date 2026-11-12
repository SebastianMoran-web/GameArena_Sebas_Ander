package com.example.GameArena.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "participacion")
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    private String puntos;
    private String posicion;

    public Participacion() {
    }

    public Participacion(Jugador jugador, Torneo torneo, String puntos, String posicion) {
        this.jugador = jugador;
        this.torneo = torneo;
        this.puntos = puntos;
        this.posicion = posicion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Jugador getJugador() { return jugador; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }

    public Torneo getTorneo() { return torneo; }
    public void setTorneo(Torneo torneo) { this.torneo = torneo; }

    public String getPuntos() { return puntos; }
    public void setPuntos(String puntos) { this.puntos = puntos; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
}
