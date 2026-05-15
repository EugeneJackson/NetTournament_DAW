package com.example.nettournament_1dawproyectofinal.model;

public class Inscripcion {

    private int idInscripcion;
    private int idJugador;
    private int idTorneo;
    private String fechaInscripcion;

    public Inscripcion(int idInscripcion, int idJugador, int idTorneo, String fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.idJugador = idJugador;
        this.idTorneo = idTorneo;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
