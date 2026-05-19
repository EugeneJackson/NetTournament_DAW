package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.PartidoJugador;

import java.util.List;

public interface IPartidoJugadorDAO {

    public void insertar(PartidoJugador partidoJugador);
    public void eliminar(int idPartidoJugador);
    public List<PartidoJugador> buscarPorPartido(int idPartido);

}
