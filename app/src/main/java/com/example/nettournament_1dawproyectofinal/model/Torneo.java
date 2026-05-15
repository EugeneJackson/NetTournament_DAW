package com.example.nettournament_1dawproyectofinal.model;

public class Torneo {

    private int idTorneo;
    private String nombre;
    private String juego;
    private String tipoCompeticion;
    private String estado;
    private String fecha_inicio;

    public Torneo(int idTorneo, String nombre, String juego, String tipoCompeticion, String estado, String fecha_inicio) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.juego = juego;
        this.tipoCompeticion = tipoCompeticion;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public String getTipoCompeticion() {
        return tipoCompeticion;
    }

    public void setTipoCompeticion(String tipoCompeticion) {
        this.tipoCompeticion = tipoCompeticion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
}
