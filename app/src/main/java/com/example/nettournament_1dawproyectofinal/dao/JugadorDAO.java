package com.example.nettournament_1dawproyectofinal.dao;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.model.Jugador;
import com.example.nettournament_1dawproyectofinal.bbdd.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JugadorDAO implements IJugadorDAO{

    private Context context;

    public JugadorDAO(Context context) {
        this.context = context;
    }

    @Override
    public void insertar(Jugador player) {

        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
              "INSERT INTO jugadores (nombre, apodo, email) VALUES (?, ?, ?)"
            );

            ps.setString(1, player.getNombre());
            ps.setString(2, player.getApodo());
            ps.setString(3, player.getEmail());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actualizar(Jugador player) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE jugadores SET nombre=?, apodo=?, email=? WHERE id_jugador=?"
            );

            ps.setString(1, player.getNombre());
            ps.setString(2, player.getApodo());
            ps.setString(3, player.getEmail());
            ps.setInt(4, player.getIdJugador());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int playerId) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM jugadores WHERE id_jugador = ?"
            );
            ps.setInt(1, playerId);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Jugador buscarPorId(int idJugador) {
        try {
            Connection con = ConexionBBDD.getConexion(context);
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM jugadores WHERE id_jugador = ?"
            );

            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Jugador playerObj = new Jugador();
                playerObj.setIdJugador(rs.getInt("id_jugador"));
                playerObj.setNombre(rs.getString("nombre"));
                playerObj.setApodo(rs.getString("apodo"));
                playerObj.setEmail(rs.getString("email"));
                return playerObj;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Jugador> buscarTodos()  {
        List<Jugador> playerList = new ArrayList<>();

        try (Connection con = ConexionBBDD.getConexion(context);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM jugadores");
            ){

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Jugador playerObj = new Jugador();

                playerObj.setIdJugador(rs.getInt("id_jugador"));
                playerObj.setNombre(rs.getString("nombre"));
                playerObj.setApodo(rs.getString("apodo"));
                playerObj.setEmail(rs.getString("email"));

                playerList.add(playerObj);
            }
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return playerList;
    }
    public boolean verificarCredenciales(String email, String password) throws Exception {
        String sql = "SELECT * FROM jugadores WHERE email = ? AND contraseña = ?";
        try (Connection con = ConexionBBDD.getConexion(context);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
