package com.example.nettournament_1dawproyectofinal.model;

public class Partido {

    private int idPartido;
    private int idTorneo;
    private int idJugador1;
    private int idJugador2;
    private String estado;

    public Partido(int idPartido, int idTorneo, int idJugador1, int idJugador2, String estado) {
        this.idPartido = idPartido;
        this.idTorneo = idTorneo;
        this.idJugador1 = idJugador1;
        this.idJugador2 = idJugador2;
        this.estado = estado;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getIdJugador1() {
        return idJugador1;
    }

    public void setIdJugador1(int idJugador1) {
        this.idJugador1 = idJugador1;
    }

    public int getIdJugador2() {
        return idJugador2;
    }

    public void setIdJugador2(int idJugador2) {
        this.idJugador2 = idJugador2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
