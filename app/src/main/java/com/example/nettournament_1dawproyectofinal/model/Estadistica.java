package com.example.nettournament_1dawproyectofinal.model;

public class Estadistica {

    private int idEstadistica;
    private int idJugador;
    private int idTorneo;
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private int puntosTotales;

    public Estadistica(int idEstadistica, int idJugador, int idTorneo, int partidosJugados, int victorias, int derrotas, int puntosTotales) {
        this.idEstadistica = idEstadistica;
        this.idJugador = idJugador;
        this.idTorneo = idTorneo;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntosTotales = puntosTotales;
    }

    public int getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
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

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    @Override
    public String toString() {
        return "Estadistica{" +
                "idEstadistica=" + idEstadistica +
                ", idJugador=" + idJugador +
                ", idTorneo=" + idTorneo +
                ", partidosJugados=" + partidosJugados +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", puntosTotales=" + puntosTotales +
                '}';
    }
}
