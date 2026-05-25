package com.example.nettournament_1dawproyectofinal.bbdd;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBBDD {

    private static Connection conexion;

    public static Connection getConexion(Context context) throws Exception {
        if (conexion == null) {
            // Lee credenciales del fichero .txt
            InputStream is = context.getAssets().open("credenciales.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String usuario = br.readLine().split("=")[1];
            String password = br.readLine().split("=")[1];
            String url = br.readLine().split("=")[1];
            br.close();

            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }
        return conexion;
    }

    public static void cerrarConexion() throws Exception {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        }
    }
}