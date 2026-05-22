package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.InscripcionDAO;
import com.example.nettournament_1dawproyectofinal.model.Inscripcion;

import java.util.List;

public class InscripcionController {

    private InscripcionDAO inscripcionDAO;

    public InscripcionController(Context context) {
        this.inscripcionDAO = new InscripcionDAO(context);
    }
    public boolean registrarInscripcion(int idJugador, int idTorneo, String fechaInscripcion) {

    }

    public boolean eliminarInscripcion(int idInscripcion) {

    }

    public Inscripcion buscarInscripcionPorId(int idInscripcion) {

    }

    public List<Inscripcion> buscarPorTorneo(int idTorneo) {

    }

    public List<Inscripcion> buscarPorJugador(int idJugador) {

    }

}
