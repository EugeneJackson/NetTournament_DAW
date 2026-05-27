package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Resultado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO resultados (id_partido, id_jugador, puntos, ganador) VALUES (?, ?, ?, ?)"
            );

            ps.setInt(1, resultado.getIdPartido());
            ps.setInt(2, resultado.getIdJugador());
            ps.setInt(3, resultado.getPuntos());
            ps.setBoolean(4, resultado.isGanador());

            ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idResultado) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM resultados WHERE id_resultado = ?"
            );

            ps.setInt(1, idResultado);
            ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Resultado> buscarPorPartido(int idPartido) {

        List<Resultado> resultadoList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM resultados WHERE id_partido = ?"
            );

            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Resultado resultObj = new Resultado();

                resultObj.setIdResultado(rs.getInt("id_resultado"));
                resultObj.setIdJugador(rs.getInt("id_jugador"));
                resultObj.setIdPartido(rs.getInt("id_partido"));
                resultObj.setPuntos(rs.getInt("puntos"));
                resultObj.setGanador(rs.getBoolean("ganador"));

                resultadoList.add(resultObj);
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultadoList;
    }

    @Override
    public List<Resultado> buscarPorJugador(int idJugador) {

        List<Resultado> jugadorQueryList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM resultados WHERE id_jugador = ?"
            );

            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Resultado resultObj = new Resultado();

                resultObj.setIdResultado(rs.getInt("id_resultado"));
                resultObj.setIdJugador(rs.getInt("id_jugador"));
                resultObj.setIdPartido(rs.getInt("id_partido"));
                resultObj.setPuntos(rs.getInt("puntos"));
                resultObj.setGanador(rs.getBoolean("ganador"));

                jugadorQueryList.add(resultObj);
            }

            ps.close();
            rs.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jugadorQueryList;
    }
}
