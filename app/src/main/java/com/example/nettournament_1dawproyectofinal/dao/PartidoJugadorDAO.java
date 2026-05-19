package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.PartidoJugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Result;

public class PartidoJugadorDAO implements IPartidoJugadorDAO{

    private Context context;

    public PartidoJugadorDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(PartidoJugador partidoJugador) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO partidos_jugadores (id_partido, id_jugador) VALUES (?, ?)"
            );

            ps.setInt(1, partidoJugador.getIdPartido());
            ps.setInt(2, partidoJugador.getIdJugador());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idPartidoJugador) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM partidos_jugadores WHERE id = ?"
            );

            ps.setInt(1, idPartidoJugador);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PartidoJugador> buscarPorPartido(int idPartido) {

        List<PartidoJugador> partidoJugadorList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM partidos_jugadores WHERE id = ?"
            );

            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                PartidoJugador partidoJugadorObj = new PartidoJugador();

                partidoJugadorObj.setIdPartidoJugador(rs.getInt("id"));
                partidoJugadorObj.setIdPartido(rs.getInt("id_partido"));
                partidoJugadorObj.setIdJugador(rs.getInt("id_jugador"));

                partidoJugadorList.add(partidoJugadorObj);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return partidoJugadorList;
    }
}
