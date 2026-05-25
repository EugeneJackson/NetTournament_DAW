package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.PartidoDAO;
import com.example.nettournament_1dawproyectofinal.model.Partido;

import java.util.List;

public class PartidoController {

    private PartidoDAO partidoDAO;

    public PartidoController(Context context) {
        this.partidoDAO = new PartidoDAO(context);
    }

    public boolean registrarPartido(int idTorneo, String estado) {
        try {

            Partido partido = new Partido();
            partido.setIdTorneo(idTorneo);
            partido.setEstado(estado);

            partidoDAO.insertar(partido);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Partido obtenerPartidoPorId(int idPartido) {
        return partidoDAO.buscarPorId(idPartido);
    }

    public List<Partido> obtenerPartidoPorTorneo(int idTorneo) {
        return partidoDAO.buscarPorTorneo(idTorneo);
    }

    public boolean actualizarPartido(Partido partido) {
        try {
            partidoDAO.actualizar(partido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarPartido(int idPartido) {
        try {
            partidoDAO.eliminar(idPartido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
