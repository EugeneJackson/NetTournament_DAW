package com.example.nettournament_1dawproyectofinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nettournament_1dawproyectofinal.controller.TorneoController;

public class TorneoDetalleActivity extends AppCompatActivity {

    private TorneoController torneoController;
    private TextView tvNombreTorneo, tvJuego, tvFecha, tvHora, tvEstado;
    private Button btnInscribirse;
    private SharedPreferences prefs;
    private int idTorneo = 1;
    private String estadoTorneoText = "Abierto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torneo_detalle);

        torneoController = new TorneoController(TorneoDetalleActivity.this);
        prefs = getSharedPreferences("InscripcionesPrefs", Context.MODE_PRIVATE);

        tvNombreTorneo = findViewById(R.id.tvNombreTorneo);
        tvJuego = findViewById(R.id.tvJuego);
        tvFecha = findViewById(R.id.tvFecha);
        tvHora = findViewById(R.id.tvHora);
        tvEstado = findViewById(R.id.tvEstado);
        btnInscribirse = findViewById(R.id.btnInscribirse);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idTorneo = extras.getInt("idTorneo", 1);
            final String nombre = extras.getString("nombreTorneo", "Torneo Desconocido");
            String rawFecha = extras.getString("fechaTorneo", "");

            estadoTorneoText = extras.getString("estadoTorneo", "Abierto");

            if (tvNombreTorneo != null) tvNombreTorneo.setText(nombre);
            if (tvJuego != null) tvJuego.setText("Videojuego: " + nombre);

            String fechaLimpia = "No disponible";
            String horaLimpia = "--:--";

            if (rawFecha != null && rawFecha.contains("Inicio: ")) {
                String datosFiltrados = rawFecha.replace("Inicio: ", "").trim();
                if (datosFiltrados.contains(" ")) {
                    String[] partes = datosFiltrados.split(" ");
                    fechaLimpia = partes[0];
                    String horaCompleta = partes[1];
                    try {
                        if (horaCompleta.contains(".")) horaCompleta = horaCompleta.split("\\.")[0];
                        if (horaCompleta.contains(":")) {
                            String[] subPartesHora = horaCompleta.split(":");
                            if (subPartesHora.length >= 2) horaLimpia = subPartesHora[0] + ":" + subPartesHora[1];
                        }
                    } catch (Exception e) { e.printStackTrace(); }
                } else {
                    fechaLimpia = datosFiltrados;
                }
            }

            if (tvFecha != null) tvFecha.setText("Fecha de inicio: " + fechaLimpia);
            if (tvHora != null) tvHora.setText("Hora de inicio: " + horaLimpia + " hs");

            configurarBotonSegunEstado(nombre);
        }
    }

    private void configurarBotonSegunEstado(String nombreTorneo) {
        boolean yaInscrito = prefs.getBoolean("inscrito_" + nombreTorneo, false);

        if (estadoTorneoText != null && (estadoTorneoText.equalsIgnoreCase("Cerrado") || estadoTorneoText.equalsIgnoreCase("Finalizado"))) {
            if (tvEstado != null) {
                tvEstado.setText("Estado: Inscripción Finalizada");
                tvEstado.setTextColor(Color.parseColor("#D32F2F"));
            }
            if (btnInscribirse != null) {
                btnInscribirse.setText("Plazo Cerrado");
                btnInscribirse.setEnabled(false);
                btnInscribirse.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#BDBDBD")));
            }
            return;
        }
        if (yaInscrito) {
            if (tvEstado != null) {
                tvEstado.setText("Estado: ¡Ya estás inscrito!");
                tvEstado.setTextColor(Color.parseColor("#2E7D32"));
            }

            if (btnInscribirse != null) {
                btnInscribirse.setText("Ver Partidos / Enfrentamientos");
                btnInscribirse.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#4CAF50")));

                btnInscribirse.setOnClickListener(v -> {
                    Intent intent = new Intent(TorneoDetalleActivity.this, PartidosTorneoActivity.class);
                    intent.putExtra("idTorneo", idTorneo);
                    startActivity(intent);
                });
            }
        } else {
            if (tvEstado != null) {
                tvEstado.setText("Estado: No inscrito");
                tvEstado.setTextColor(Color.parseColor("#757575"));
            }

            if (btnInscribirse != null) {
                btnInscribirse.setText("Inscribirse al Torneo");
                btnInscribirse.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#1E88E5")));

                btnInscribirse.setOnClickListener(v -> {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("inscrito_" + nombreTorneo, true);
                    editor.apply();

                    Toast.makeText(TorneoDetalleActivity.this, "Inscripción realizada con éxito", Toast.LENGTH_SHORT).show();

                    configurarBotonSegunEstado(nombreTorneo);
                });
            }
        }
    }
}