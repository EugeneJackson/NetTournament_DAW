package com.example.nettournament_1dawproyectofinal.dao;

import com.example.nettournament_1dawproyectofinal.model.Resultado;

import java.util.List;

public interface IResultadoDAO {

    public void insertar(Resultado resultado);
    public void eliminar(int idResultado);
    public List<Resultado> buscarPorPartido(int idPartido);
    public List<Resultado> buscarPorJugador(int idJugador);


}
