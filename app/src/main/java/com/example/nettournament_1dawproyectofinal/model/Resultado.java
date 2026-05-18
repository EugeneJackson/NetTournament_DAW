package com.example.nettournament_1dawproyectofinal.model;

public class Resultado {

    private int idResultado;
    private int idPartido;
    private int idGanador;
    private int puntos;
    private boolean ganador;

    public Resultado(int idResultado, int idPartido, int idGanador, int puntos, boolean ganador) {
        this.idResultado = idResultado;
        this.idPartido = idPartido;
        this.idGanador = idGanador;
        this.puntos = puntos;
        this.ganador = ganador;
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

    public int getIdGanador() {
        return idGanador;
    }

    public void setIdGanador(int idGanador) {
        this.idGanador = idGanador;
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
                ", idGanador=" + idGanador +
                ", puntos=" + puntos +
                ", ganador=" + ganador +
                '}';
    }
}
