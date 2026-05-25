package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.TorneoDAO;
import com.example.nettournament_1dawproyectofinal.model.Torneo;

import java.util.List;

public class TorneoController {

    private TorneoDAO torneoDAO;

    public TorneoController(Context context) {
        this.torneoDAO = new TorneoDAO(context);
    }

    public boolean registrarTorneo(String nombre, String tipo, String estado, String fecha_inicio) {

        try {

            Torneo torneo = new Torneo();
            torneo.setNombre(nombre);
            torneo.setTipo(tipo);
            torneo.setEstado(estado);
            torneo.setFecha_inicio(fecha_inicio);

            torneoDAO.insertar(torneo);

            return true;

        } catch(Exception e) {
            return false;
        }

    }

    public Torneo obtenerPorId(int idTorneo) {
        return torneoDAO.buscarPorId(idTorneo);
    }

    public List<Torneo> obtenerTodosLosTorneos() {
        return torneoDAO.buscarTodos();
    }

    public boolean actualizarTorneo(Torneo torneo) {
        try {
            torneoDAO.actualizar(torneo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarTorneo(int idTorneo) {

        try {
            torneoDAO.eliminar(idTorneo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
