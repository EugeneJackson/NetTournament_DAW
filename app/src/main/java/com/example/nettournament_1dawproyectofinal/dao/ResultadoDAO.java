package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Resultado;

import java.util.Collections;
import java.util.List;

public class ResultadoDAO implements IResultadoDAO{

    private Context context;

    public ResultadoDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Resultado resultado) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idResultado) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Resultado> buscarPorPartido(int idPartido) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Resultado> buscarPorJugador(int idJugador) {
        try {
            ConexionBBDD.getConexion(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }
}
