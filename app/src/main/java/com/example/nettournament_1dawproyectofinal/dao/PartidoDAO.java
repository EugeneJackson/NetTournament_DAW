package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Partido;

import java.sql.*;
import java.util.ArrayList;
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
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO partidos (id_torneo, estado) VALUES (?, ?)"
            );

            ps.setInt(1, partido.getIdTorneo());
            ps.setString(2, partido.getEstado());

            ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Partido partido) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE partidos SET id_torneo=?, estado=? WHERE id_partido=?"
            );

            ps.setInt(1, partido.getIdTorneo());
            ps.setString(2, partido.getEstado());
            ps.setInt(3, partido.getIdPartido());

            ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idPartido) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM partidos WHERE id_partido = ?"
            );

            ps.setInt(1, idPartido);
            ps.executeUpdate();

            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Partido buscarPorId(int idPartido) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM partidos WHERE id_partido = ?"
            );

            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Partido partidoObj = new Partido();

                partidoObj.setIdPartido(rs.getInt("id_partido"));
                partidoObj.setIdTorneo(rs.getInt("id_torneo"));
                partidoObj.setEstado(rs.getString("estado"));

                return partidoObj;
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Partido> buscarPorTorneo(int idTorneo) {

        List<Partido> partidoList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM partidos WHERE id_torneo = ?"
            );

            ps.setInt(1, idTorneo);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Partido partidoObj = new Partido();

                partidoObj.setIdPartido(rs.getInt("id_partido"));
                partidoObj.setIdTorneo(rs.getInt("id_torneo"));
                partidoObj.setEstado(rs.getString("estado"));

                partidoList.add(partidoObj);
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return partidoList;
    }
}
