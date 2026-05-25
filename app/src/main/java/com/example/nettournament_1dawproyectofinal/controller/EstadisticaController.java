package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.EstadisticaDAO;
import com.example.nettournament_1dawproyectofinal.model.Estadistica;

import java.util.List;

public class EstadisticaController {

    private EstadisticaDAO statisticDAO;

    public EstadisticaController(Context context) {
        this.statisticDAO = new EstadisticaDAO(context);
    }


    public boolean insertarEstadistica(int idJugador, int idTorneo, int partidosJugados, int victorias, int derrotas, int puntosTotales) {

        try {
            Estadistica statistic = new Estadistica();

            statistic.setIdJugador(idJugador);
            statistic.setIdTorneo(idTorneo);
            statistic.setPartidosJugados(partidosJugados);
            statistic.setVictorias(victorias);
            statistic.setDerrotas(derrotas);
            statistic.setPuntosTotales(puntosTotales);

            statisticDAO.insertar(statistic);

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizarEstadistica(Estadistica statistic) {

        try {
            statisticDAO.actualizar(statistic);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Estadistica> buscarEstadisticaPorJugador(int idJugador) {
        return statisticDAO.buscarPorJugador(idJugador);
    }

    public List<Estadistica> buscarEstadisticaPorTorneo(int idTorneo) {
        return statisticDAO.buscarPorTorneo(idTorneo);
    }

    public Estadistica buscarEstadisticaPorJugadorYPorTorneo(int idJugador, int idTorneo) {
        return statisticDAO.buscarPorJugadorYTorneo(idJugador, idTorneo);
    }

}
