package com.example.GameArena.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore; // <--- AÑADE ESTE IMPORT
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nick;
    private String email;
    private String nivel;

    @OneToMany(mappedBy = "jugador")
    @JsonIgnore
    private List<Participacion> participaciones;

    public Jugador() {

    }

    @OneToMany(mappedBy = "jugador")
    @JsonIgnore
    private List<Participacion> participacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}