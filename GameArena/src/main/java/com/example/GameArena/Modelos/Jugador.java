package com.example.GameArena.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name="Jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Log  id;

    private String nick;
    private String email;
    private String nivel;

    public Jugador() {

    }

    public String getNick() {
        return nick;
    }

    public void getNick(String nick) {
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
