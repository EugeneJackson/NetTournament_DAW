package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.bbdd.ConexionBBDD;
import com.example.nettournament_1dawproyectofinal.model.Estadistica;
import com.example.nettournament_1dawproyectofinal.model.Resultado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO estadisticas (id_jugador, id_torneo, partidos_jugados, victorias, derrotas, puntos_totales) VALUES (?, ?, ?, ?, ?, ?)"
            );

            ps.setInt(1, estadistica.getIdJugador());
            ps.setInt(2, estadistica.getIdTorneo());
            ps.setInt(3, estadistica.getPartidosJugados());
            ps.setInt(4, estadistica.getVictorias());
            ps.setInt(5, estadistica.getDerrotas());
            ps.setInt(6, estadistica.getPuntosTotales());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Estadistica estadistica) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE estadisticas SET id_jugador=?, id_torneo=?, partidos_jugados=?, victorias=?, derrotas=?, puntos_totales=? WHERE id_estadistica=?"
            );

            ps.setInt(1, estadistica.getIdJugador());
            ps.setInt(2, estadistica.getIdTorneo());
            ps.setInt(3, estadistica.getPartidosJugados());
            ps.setInt(4, estadistica.getVictorias());
            ps.setInt(5, estadistica.getDerrotas());
            ps.setInt(6, estadistica.getPuntosTotales());
            ps.setInt(7, estadistica.getIdEstadistica());

            ps.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Estadistica> buscarPorJugador(int idJugador) {

        List<Estadistica> jugadorQueryList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM estadisticas WHERE id_jugador = ?"
            );

            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Estadistica estadisticaObj = new Estadistica();

                estadisticaObj.setIdEstadistica(rs.getInt("id_estadistica"));
                estadisticaObj.setIdJugador(rs.getInt("id_jugador"));
                estadisticaObj.setIdTorneo(rs.getInt("id_torneo"));
                estadisticaObj.setPartidosJugados(rs.getInt("partidos_jugados"));
                estadisticaObj.setVictorias(rs.getInt("victorias"));
                estadisticaObj.setDerrotas(rs.getInt("derrotas"));
                estadisticaObj.setPuntosTotales(rs.getInt("puntos_totales"));

                jugadorQueryList.add(estadisticaObj);

            }

            rs.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jugadorQueryList;
    }

    @Override
    public List<Estadistica> buscarPorTorneo(int idTorneo) {

        List<Estadistica> torneoQueryList = new ArrayList<>();

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM estadisticas WHERE id_torneo = ?"
            );

            ps.setInt(1, idTorneo);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Estadistica estadisticaObj = new Estadistica();

                estadisticaObj.setIdEstadistica(rs.getInt("id_estadistica"));
                estadisticaObj.setIdJugador(rs.getInt("id_jugador"));
                estadisticaObj.setIdTorneo(rs.getInt("id_torneo"));
                estadisticaObj.setPartidosJugados(rs.getInt("partidos_jugados"));
                estadisticaObj.setVictorias(rs.getInt("victorias"));
                estadisticaObj.setDerrotas(rs.getInt("derrotas"));
                estadisticaObj.setPuntosTotales(rs.getInt("puntos_totales"));

                torneoQueryList.add(estadisticaObj);

            }

            rs.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return torneoQueryList;
    }

    @Override
    public Estadistica buscarPorJugadorYTorneo(int idJugador, int idTorneo) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM estadisticas WHERE id_jugador = ? AND id_torneo = ?"
            );

            ps.setInt(1, idJugador);
            ps.setInt(2, idTorneo);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Estadistica estadisticaObj = new Estadistica();

                estadisticaObj.setIdEstadistica(rs.getInt("id_estadistica"));
                estadisticaObj.setIdJugador(rs.getInt("id_jugador"));
                estadisticaObj.setIdTorneo(rs.getInt("id_torneo"));
                estadisticaObj.setPartidosJugados(rs.getInt("partidos_jugados"));
                estadisticaObj.setVictorias(rs.getInt("victorias"));
                estadisticaObj.setDerrotas(rs.getInt("derrotas"));
                estadisticaObj.setPuntosTotales(rs.getInt("puntos_totales"));

                return estadisticaObj;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
