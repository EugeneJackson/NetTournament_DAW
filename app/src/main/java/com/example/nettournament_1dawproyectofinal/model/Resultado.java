package com.example.nettournament_1dawproyectofinal.model;

public class Resultado {

    private int idResultado;
    private int idPartido;
    private int idJugador;
    private int puntos;
    private boolean ganador;

    public Resultado() {
    }

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "idResultado=" + idResultado +
                ", idPartido=" + idPartido +
                ", idJugador=" + idJugador +
                ", puntos=" + puntos +
                ", ganador=" + ganador +
                '}';
    }
}
