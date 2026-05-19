package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.Jugador;

import java.util.*;

public interface IJugadorDAO {

    public void insertar(Jugador player);
    public void actualizar(Jugador player);
    public void eliminar(int playerId);
    public Jugador buscarPorId(int idJugador);
    public List<Jugador> buscarTodos();

}
