package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Torneo;

import java.util.Collections;
import java.util.List;

public class TorneoDAO implements ITorneoDAO {

    private Context context;

    public TorneoDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Torneo torneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idTorneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Torneo torneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Torneo buscarPorId(int idTorneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Torneo> buscarTodos() {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }
}
