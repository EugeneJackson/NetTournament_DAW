package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.InscripcionDAO;
import com.example.nettournament_1dawproyectofinal.model.Inscripcion;

import java.util.ArrayList;
import java.util.List;

public class InscripcionController {

    private InscripcionDAO inscripcionDAO;

    public InscripcionController(Context context) {
        this.inscripcionDAO = new InscripcionDAO(context);
    }
    public boolean registrarInscripcion(int idJugador, int idTorneo, String fechaInscripcion) {

        try {
            Inscripcion inscription = new Inscripcion();
            inscription.setIdJugador(idJugador);
            inscription.setIdTorneo(idTorneo);
            inscription.setFechaInscripcion(fechaInscripcion);

            inscripcionDAO.insertar(inscription);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean eliminarInscripcion(int idInscripcion) {

        try {
            inscripcionDAO.eliminar(idInscripcion);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Inscripcion buscarInscripcionPorId(int idInscripcion) {
        return inscripcionDAO.buscarPorId(idInscripcion);
    }

    public List<Inscripcion> buscarPorTorneo(int idTorneo) {
        return inscripcionDAO.buscarPorTorneo(idTorneo);
    }

    public List<Inscripcion> buscarPorJugador(int idJugador) {
        return inscripcionDAO.buscarPorJugador(idJugador);
    }

}
