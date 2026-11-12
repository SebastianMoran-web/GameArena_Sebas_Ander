package com.example.GameArena.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore; // <--- AÑADE ESTE IMPORT
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fecha;
    private String premio;
    private String estado;

    @OneToMany(mappedBy = "torneo")
    @JsonIgnore
    private List<Participacion> participaciones;

    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    private Videojuego videojuego;

    public Torneo() {
    }

    @OneToMany(mappedBy = "torneo")
    @JsonIgnore // <--- AÑADE ESTA LÍNEA AQUÍ TAMBIÉN
    private List<Participacion> participacion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getPremio() { return premio; }
    public void setPremio(String premio) { this.premio = premio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<Participacion> getParticipaciones() { return participaciones; }
    public void setParticipaciones(List<Participacion> participaciones) { this.participaciones = participaciones; }

    public Videojuego getVideojuego() { return videojuego; }
    public void setVideojuego(Videojuego videojuego) { this.videojuego = videojuego; }
}