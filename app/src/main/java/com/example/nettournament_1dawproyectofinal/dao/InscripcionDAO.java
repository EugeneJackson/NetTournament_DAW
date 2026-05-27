package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Inscripcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Result;

public class InscripcionDAO implements IInscripcionDAO{

    private Context context;

    public InscripcionDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Inscripcion inscripcion) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO inscripciones (id_jugador, id_torneo, fecha_inscripcion) VALUES (?, ?, ?)"
            );

            ps.setInt(1, inscripcion.getIdJugador());
            ps.setInt(2, inscripcion.getIdTorneo());
            ps.setString(3, inscripcion.getFechaInscripcion());

            ps.executeUpdate();

            ps.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idInscripcion) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM inscripciones WHERE id_inscripcion = ?"
            );

            ps.setInt(1, idInscripcion);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Inscripcion buscarPorId(int idInscripcion) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM inscripciones WHERE id_inscripcion = ?"
            );

            ps.setInt(1, idInscripcion);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Inscripcion inscripcionObj = new Inscripcion();

                inscripcionObj.setIdInscripcion(rs.getInt("id_inscripcion"));
                inscripcionObj.setIdJugador(rs.getInt("id_jugador"));
                inscripcionObj.setIdTorneo(rs.getInt("id_torneo"));
                inscripcionObj.setFechaInscripcion(rs.getString("fecha_inscripcion"));

                return inscripcionObj;

            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Inscripcion> buscarPorTorneo(int idTorneo) {

        List<Inscripcion> inscripcionList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM inscripciones WHERE id_torneo = ?"
            );

            ps.setInt(1, idTorneo);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Inscripcion inscripcionObj = new Inscripcion();

                inscripcionObj.setIdInscripcion(rs.getInt("id_inscripcion"));
                inscripcionObj.setIdJugador(rs.getInt("id_jugador"));
                inscripcionObj.setIdTorneo(rs.getInt("id_torneo"));
                inscripcionObj.setFechaInscripcion(rs.getString("fecha_inscripcion"));

                inscripcionList.add(inscripcionObj);

            }

            ps.close();
            rs.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inscripcionList;
    }

    @Override
    public List<Inscripcion> buscarPorJugador(int idJugador) {

        List<Inscripcion> jugadorInscritoList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM inscripciones WHERE id_jugador = ?"
            );

            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Inscripcion inscripcionObj = new Inscripcion();

                inscripcionObj.setIdInscripcion(rs.getInt("id_inscripcion"));
                inscripcionObj.setIdJugador(rs.getInt("id_jugador"));
                inscripcionObj.setIdTorneo(rs.getInt("id_torneo"));
                inscripcionObj.setFechaInscripcion(rs.getString("fecha_inscripcion"));

                jugadorInscritoList.add(inscripcionObj);
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jugadorInscritoList;
    }
}
