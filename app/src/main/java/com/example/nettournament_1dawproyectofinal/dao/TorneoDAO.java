package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Torneo;

import java.sql.*;
import java.util.ArrayList;
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
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO torneos (nombre, tipo, estado, fecha_inicio) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, torneo.getNombre());
            ps.setString(2, torneo.getTipo());
            ps.setString(3, torneo.getEstado());
            ps.setString(4, torneo.getFecha_inicio());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int idTorneo) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM torneos WHERE id_torneo = ?"
            );

            ps.setInt(1, idTorneo);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Torneo torneo) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE torneos SET nombre=?, tipo=?, estado=?, fecha_inicio=? WHERE id_torneo=?"
            );

            ps.setString(1, torneo.getNombre());
            ps.setString(2, torneo.getTipo());
            ps.setString(3, torneo.getEstado());
            ps.setString(4, torneo.getFecha_inicio());
            ps.setInt(5, torneo.getIdTorneo());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Torneo buscarPorId(int idTorneo) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM torneos WHERE id_torneo = ?"
            );

            ps.setInt(1, idTorneo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Torneo torneoObj = new Torneo();
                torneoObj.setIdTorneo(rs.getInt("id_torneo"));
                torneoObj.setNombre(rs.getString("nombre"));
                torneoObj.setTipo((rs.getString("tipo")));
                torneoObj.setEstado(rs.getString("estado"));
                torneoObj.setFecha_inicio(rs.getString("fecha_inicio"));
                return torneoObj;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Torneo> buscarTodos() {
        List<Torneo> torneoList = new ArrayList<>();
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM torneos"
            );

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Torneo torneoObj = new Torneo();
                torneoObj.setIdTorneo(rs.getInt("id_torneo"));
                torneoObj.setNombre(rs.getString("nombre"));
                torneoObj.setTipo((rs.getString("tipo")));
                torneoObj.setEstado(rs.getString("estado"));
                torneoObj.setFecha_inicio(rs.getString("fecha_inicio"));

                torneoList.add(torneoObj);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return torneoList;
    }

    public void insertarInscripcion(int idJugador, int idTorneo) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO inscripciones (id_jugador, id_torneo, fecha_inscripcion) VALUES (?, ?, CURDATE())"
            );

            ps.setInt(1, idJugador);
            ps.setInt(2, idTorneo);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}