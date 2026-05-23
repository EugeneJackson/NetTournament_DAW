package com.example.nettournament_1dawproyectofinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nettournament_1dawproyectofinal.controlador.InscripcionController;

public class InscripcionActivity extends AppCompatActivity {

    private InscripcionController inscripcionController;
    private TextView tvConfirmacion;
    private Button btnConfirmarInscripcion;
    private int idTorneo;
    private int idJugadorLogueado = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion);
        inscripcionController = new InscripcionController(InscripcionActivity.this);

        tvConfirmacion = findViewById(R.id.tvConfirmacion);
        btnConfirmarInscripcion = findViewById(R.id.btnConfirmarInscripcion);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idTorneo = extras.getInt("id_torneo", 0);
            String nombreTorneo = extras.getString("nombre_torneo", "este torneo");
            tvConfirmacion.setText("¿Estás seguro de que deseas inscribirte en " + nombreTorneo + "?");
        }

        btnConfirmarInscripcion.setOnClickListener(v -> {
        inscripcionController.procesarInscripcion(idJugadorLogueado, idTorneo, new InscripcionController.OnInscripcionListener() {
            @Override
            public void onSuccess() {
                runOnUiThread(() -> {
                Toast.makeText(InscripcionActivity.this, "¡Inscripción confirmada con éxito!", Toast.LENGTH_LONG).show();
                finish();
            });
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(() -> {
                Toast.makeText(InscripcionActivity.this, "Error: Ya estás inscrito o el torneo está lleno", Toast.LENGTH_LONG).show();
            });
            }
        });
    });
    }
}