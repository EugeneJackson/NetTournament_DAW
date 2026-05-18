package com.example.nettournament_1dawproyectofinal.model;

public class Partido {

    private int idPartido;
    private int idTorneo;
    private String estado;

    public Partido(int idPartido, int idTorneo, String estado) {
        this.idPartido = idPartido;
        this.idTorneo = idTorneo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", idTorneo=" + idTorneo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
