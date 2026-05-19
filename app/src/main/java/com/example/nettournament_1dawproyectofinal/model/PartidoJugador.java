package com.example.nettournament_1dawproyectofinal.model;

public class PartidoJugador {

    private int idPartidoJugador;
    private int idPartido;
    private int idJugador;

    public PartidoJugador() {
    }

    public int getIdPartidoJugador() {
        return idPartidoJugador;
    }

    public void setIdPartidoJugador(int idPartidoJugador) {
        this.idPartidoJugador = idPartidoJugador;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    @Override
    public String toString() {
        return "PartidoJugador{" +
                "idPartidoJugador=" + idPartidoJugador +
                ", idPartido=" + idPartido +
                ", idJugador=" + idJugador +
                '}';
    }
}
