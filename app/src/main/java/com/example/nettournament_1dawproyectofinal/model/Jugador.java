package com.example.nettournament_1dawproyectofinal.model;

public class Jugador {

    private int idJugador;
    private String nombre;
    private String apodo;
    private String email;

    public Jugador(int idJugador, String nombre, String apodo, String email) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apodo = apodo;
        this.email = email;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", nombre='" + nombre + '\'' +
                ", apodo='" + apodo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
