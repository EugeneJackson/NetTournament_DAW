package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.model.Jugador;
import com.example.nettournament_1dawproyectofinal.bbdd.*;

import java.util.Collections;
import java.util.List;

public class JugadorDAO implements IJugadorDAO{

    private Context context;

    public JugadorDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Jugador player) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Jugador player) {

    }

    @Override
    public void eliminar(int playerId) {

    }

    @Override
    public Jugador buscarPorId(int idJugador) {
        return null;
    }

    @Override
    public List<Jugador> buscarTodos() {
        return Collections.emptyList();
    }
}
