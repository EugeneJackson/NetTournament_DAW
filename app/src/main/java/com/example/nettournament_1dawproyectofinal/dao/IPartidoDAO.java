package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.Partido;

import java.util.List;

public interface IPartidoDAO {

    public void insertar(Partido partido);
    public void actualizar(Partido partido);
    public void eliminar(int idPartido);
    public Partido buscarPorId(int idPartido);
    public List<Partido> buscarPorTorneo(int idTorneo);
}
