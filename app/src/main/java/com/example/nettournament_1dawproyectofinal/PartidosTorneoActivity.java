package com.example.nettournament_1dawproyectofinal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.nettournament_1dawproyectofinal.controller.PartidoController;
import com.example.nettournament_1dawproyectofinal.model.Partido;
import java.util.List;

public class PartidosTorneoActivity extends AppCompatActivity {

    private PartidoController partidoController;
    private LinearLayout containerPartidos;
    private int idTorneoSeleccionado = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos_torneo);

        partidoController = new PartidoController(this);
        containerPartidos = findViewById(R.id.containerPartidos);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idTorneoSeleccionado = extras.getInt("idTorneo", 1);
        }

        cargarPartidosDinamicos();
    }

    private void cargarPartidosDinamicos() {
        new Thread(() -> {
            List<Partido> listaPartidos = partidoController.obtenerPartidoPorTorneo(idTorneoSeleccionado);

            runOnUiThread(() -> {
                if (containerPartidos == null) return;

                containerPartidos.removeAllViews();

                if (listaPartidos != null && !listaPartidos.isEmpty()) {
                    for (Partido partido : listaPartidos) {
                        agregarTarjetaPartido(
                                "Partido #" + partido.getIdPartido(),
                                "Estado: " + partido.getEstado(),
                                "Marcador disponible en sistema"
                        );
                    }
                } else {
                    mostrarAvisoPartidosNoIniciados();
                }
            });
        }).start();
    }

    private void mostrarAvisoPartidosNoIniciados() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Torneo en Espera");
        builder.setMessage("Los partidos y emparejamientos de este torneo aún no se han generado. Por favor, vuelve a consultar cuando finalice el periodo de inscripción.");

        builder.setCancelable(false);

        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void agregarTarjetaPartido(String titulo, String enfrentamiento, String resultado) {
        CardView card = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 0, 0, 24);
        card.setLayoutParams(layoutParams);
        card.setRadius(16f);
        card.setCardElevation(4f);
        card.setContentPadding(24, 24, 24, 24);

        LinearLayout layoutInterno = new LinearLayout(this);
        layoutInterno.setOrientation(LinearLayout.VERTICAL);

        TextView tvTitulo = new TextView(this);
        tvTitulo.setText(titulo);
        tvTitulo.setTextSize(14);
        tvTitulo.setTextColor(android.graphics.Color.parseColor("#757575"));
        tvTitulo.setPadding(0, 0, 0, 8);

        TextView tvEnfrentamiento = new TextView(this);
        tvEnfrentamiento.setText(enfrentamiento);
        tvEnfrentamiento.setTextSize(18);
        tvEnfrentamiento.setTextColor(android.graphics.Color.parseColor("#212121"));
        tvEnfrentamiento.setTypeface(null, android.graphics.Typeface.BOLD);

        TextView tvResultado = new TextView(this);
        tvResultado.setText(resultado);
        tvResultado.setTextSize(16);
        tvResultado.setTextColor(android.graphics.Color.parseColor("#1E88E5"));
        tvResultado.setPadding(0, 8, 0, 0);

        layoutInterno.addView(tvTitulo);
        layoutInterno.addView(tvEnfrentamiento);
        layoutInterno.addView(tvResultado);

        card.addView(layoutInterno);
        containerPartidos.addView(card);
    }
}