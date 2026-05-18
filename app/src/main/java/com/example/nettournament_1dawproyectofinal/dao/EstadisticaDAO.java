package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Estadistica;

import java.util.Collections;
import java.util.List;

public class EstadisticaDAO implements IEstadisticaDAO{

    private Context context;

    public EstadisticaDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Estadistica estadistica) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Estadistica estadistica) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Estadistica> buscarPorJugador(int idJugador) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Estadistica> buscarPorTorneo(int idTorneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }

    @Override
    public Estadistica buscarPorJugadorYTorneo(int idJugador, int idTorneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
