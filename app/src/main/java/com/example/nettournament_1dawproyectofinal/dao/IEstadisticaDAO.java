package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.Estadistica;

import java.util.List;

public interface IEstadisticaDAO {

    public void insertar(Estadistica estadistica);
    public void actualizar(Estadistica estadistica);
    public List<Estadistica> buscarPorJugador(int idJugador);
    public List<Estadistica> buscarPorTorneo(int idTorneo);
    public Estadistica buscarPorJugadorYTorneo(int idJugador, int idTorneo);
}
