package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.Torneo;

import java.util.List;

public interface ITorneoDAO {

    public void insertar(Torneo torneo);
    public void eliminar(int idTorneo);
    public void actualizar(Torneo torneo);
    public Torneo buscarPorId(int idTorneo);
    public List<Torneo> buscarTodos();

}
