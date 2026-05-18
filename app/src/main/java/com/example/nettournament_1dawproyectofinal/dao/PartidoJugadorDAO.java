package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.PartidoJugador;

import java.util.Collections;
import java.util.List;

public class PartidoJugadorDAO implements IPartidoJugadorDAO{

    private Context context;

    public PartidoJugadorDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(PartidoJugador partidoJugador) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idPartidoJugador) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PartidoJugador> buscarPorPartido(int idPartido) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Collections.emptyList();
    }
}
