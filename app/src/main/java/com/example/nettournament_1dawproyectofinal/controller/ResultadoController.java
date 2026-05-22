package com.example.nettournament_1dawproyectofinal.controller;

import android.content.Context;

import com.example.nettournament_1dawproyectofinal.dao.PartidoDAO;
import com.example.nettournament_1dawproyectofinal.dao.ResultadoDAO;
import com.example.nettournament_1dawproyectofinal.model.Resultado;

import java.util.List;

import javax.xml.transform.Result;

public class ResultadoController {

    private ResultadoDAO resultadoDAO;

    public ResultadoController(Context context) {
        this.resultadoDAO = new ResultadoDAO(context);
    }

    public boolean registrarResultado(int idPartido, int idJugador, boolean ganador, int puntos) {

        try {
            Resultado result = new Resultado();
            result.setIdPartido(idPartido);
            result.setIdJugador(idJugador);
            result.setGanador(ganador);
            result.setPuntos(puntos);

            resultadoDAO.insertar(result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean eliminarResultado(int idResultado) {

        try {
            resultadoDAO.eliminar(idResultado);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Resultado> buscarPorPartido(int idPartido) {
        return resultadoDAO.buscarPorPartido(idPartido);
    }

    public List<Resultado> buscarPorJugador(int idJugador) {
        return resultadoDAO.buscarPorJugador(idJugador);
    }

}
