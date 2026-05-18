package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.Inscripcion;

import java.util.List;

public interface IInscripcionDAO {

    public void insertar(Inscripcion inscripcion);
    public void eliminar(int idInscripcion);
    public Inscripcion buscarPorId(int idInscripcion);
    public List<Inscripcion> buscarPorTorneo(int idTorneo);
    public List<Inscripcion> buscarPorJugador(int idJugador);
}
