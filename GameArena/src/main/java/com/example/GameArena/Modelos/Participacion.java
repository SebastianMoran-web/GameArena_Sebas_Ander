package com.example.GameArena.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "participacion")
public class Participacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String torneo;
    private String puntos;
    private String posicion;

    public Participacion() {
    }

    public Participacion(
            String nickname,
            String torneo,
            String puntos,
            String posicion) {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getTorneo() {
        return torneo;
    }
    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }
    public String getPuntos() {
        return puntos;
    }
    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

}
