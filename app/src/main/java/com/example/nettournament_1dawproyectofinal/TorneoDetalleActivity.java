package com.example.nettournament_1dawproyectofinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nettournament_1dawproyectofinal.controller.TorneoController;

public class TorneoDetalleActivity extends AppCompatActivity {

    private TorneoController torneoController;
    private TextView tvNombreTorneo, tvJuego, tvFecha, tvPlazas;
    private Button btnInscribirse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torneo_detalle);

        torneoController = new TorneoController(TorneoDetalleActivity.this);

        tvNombreTorneo = findViewById(R.id.tvNombreTorneo);
        tvJuego = findViewById(R.id.tvJuego);
        tvFecha = findViewById(R.id.tvFecha);
        tvPlazas = findViewById(R.id.tvPlazas);
        btnInscribirse = findViewById(R.id.btnInscribirse);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre_torneo", "Torneo Desconocido");
            String juego = extras.getString("juego_torneo", "No especificado");
            String fecha = extras.getString("fecha_torneo", "--/--/----");
            int plazasOcupadas = extras.getInt("plazas_ocupadas", 0);
            int plazasMaximas = extras.getInt("plazas_maximas", 16);

            tvNombreTorneo.setText(nombre);
            tvJuego.setText("Videojuego: " + juego);
            tvFecha.setText("Fecha de inicio: " + fecha);
            tvPlazas.setText("Plazas: " + plazasOcupadas + " / " + plazasMaximas);

            if (!torneoController.validarPlazasDisponibles(plazasOcupadas, plazasMaximas)) {
                btnInscribirse.setEnabled(false);
                btnInscribirse.setText("Torneo Lleno");
            }
        }

        btnInscribirse.setOnClickListener(v -> {
        Toast.makeText(TorneoDetalleActivity.this, "Abriendo formulario de inscripción...", Toast.LENGTH_SHORT).show();
    });
    }
}