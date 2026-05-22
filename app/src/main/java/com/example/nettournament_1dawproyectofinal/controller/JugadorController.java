package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.JugadorDAO;
import com.example.nettournament_1dawproyectofinal.model.Jugador;

import java.util.List;

public class JugadorController {

    private JugadorDAO jugadorDAO;

    public JugadorController(Context context) {
        this.jugadorDAO = new JugadorDAO(context);
    }

    public boolean registrarJugador(String nombre, String apodo, String email) {

        try {
            Jugador jugador = new Jugador();
            jugador.setNombre(nombre);
            jugador.setApodo(apodo);
            jugador.setEmail(email);

            jugadorDAO.insertar(jugador);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Jugador obtenerJugador(int idJugador) {
        return jugadorDAO.buscarPorId(idJugador);
    }

    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorDAO.buscarTodos();
    }

    public boolean actualizarJugador(Jugador player) {

        try {
            jugadorDAO.actualizar(player);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarJugador(int idJugador) {

        try {
            jugadorDAO.eliminar(idJugador);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
