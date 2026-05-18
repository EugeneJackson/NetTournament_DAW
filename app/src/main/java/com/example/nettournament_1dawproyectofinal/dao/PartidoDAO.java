package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Partido;

import java.util.Collections;
import java.util.List;

public class PartidoDAO implements IPartidoDAO{

    private Context context;

    public PartidoDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Partido partido) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Partido partido) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idPartido) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Partido buscarPorId(int idPartido) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Partido> buscarPorTorneo(int idTorneo) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }
}
