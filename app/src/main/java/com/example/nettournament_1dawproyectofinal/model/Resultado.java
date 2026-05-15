package com.example.nettournament_1dawproyectofinal.model;

public class Resultado {

    private int idResultado;
    private int idPartido;
    private int puntuacionJ1;
    private int puntuacionJ2;
    private int idGanador;

    public Resultado(int idResultado, int idPartido, int puntuacionJ1, int puntuacionJ2, int idGanador) {
        this.idResultado = idResultado;
        this.idPartido = idPartido;
        this.puntuacionJ1 = puntuacionJ1;
        this.puntuacionJ2 = puntuacionJ2;
        this.idGanador = idGanador;
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

    public int getPuntuacionJ1() {
        return puntuacionJ1;
    }

    public void setPuntuacionJ1(int puntuacionJ1) {
        this.puntuacionJ1 = puntuacionJ1;
    }

    public int getPuntuacionJ2() {
        return puntuacionJ2;
    }

    public void setPuntuacionJ2(int puntuacionJ2) {
        this.puntuacionJ2 = puntuacionJ2;
    }

    public int getIdGanador() {
        return idGanador;
    }

    public void setIdGanador(int idGanador) {
        this.idGanador = idGanador;
    }
}
