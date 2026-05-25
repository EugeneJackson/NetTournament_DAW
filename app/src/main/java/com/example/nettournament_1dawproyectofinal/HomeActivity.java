package com.example.nettournament_1dawproyectofinal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nettournament_1dawproyectofinal.controller.TorneoController;
import com.example.nettournament_1dawproyectofinal.model.Torneo;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private EditText etBuscar;
    private Button btnCrearTorneoHome;
    private RecyclerView rvTorneos;
    private TorneoAdapter torneoAdapter;
    private TorneoController torneoController;
    private List<Torneo> listaTorneosCompleta = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        torneoController = new TorneoController(HomeActivity.this);
        etBuscar = findViewById(R.id.etBuscar);
        btnCrearTorneoHome = findViewById(R.id.btnCrearTorneoHome);

        rvTorneos = findViewById(R.id.rvTorneos);
        rvTorneos.setLayoutManager(new LinearLayoutManager(this));

        torneoAdapter = new TorneoAdapter(new ArrayList<>(), this);
        rvTorneos.setAdapter(torneoAdapter);

        cargarTorneosDesdeBD();

        btnCrearTorneoHome.setOnClickListener(v -> mostrarDialogoCrearTorneo());

        if (etBuscar != null) {
            etBuscar.addTextChangedListener(new android.text.TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String textoBuscado = s.toString().trim().toLowerCase();

                    if (textoBuscado.isEmpty()) {
                        torneoAdapter.actualizarLista(listaTorneosCompleta);
                        return;
                    }
                    List<Torneo> listaFiltrada = new ArrayList<>();

                    for (Torneo torneo : listaTorneosCompleta) {
                        if (torneo.getNombre() != null && torneo.getNombre().toLowerCase().contains(textoBuscado)) {
                            listaFiltrada.add(torneo);
                        }
                    }

                    torneoAdapter.actualizarLista(listaFiltrada);
                }

                @Override
                public void afterTextChanged(android.text.Editable s) {}
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarTorneosDesdeBD();
    }

    private void cargarTorneosDesdeBD() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<Torneo> lista = torneoController.obtenerTodosLosTorneos();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (lista != null) {
                                listaTorneosCompleta = lista;
                                torneoAdapter.actualizarLista(lista);
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void mostrarDialogoCrearTorneo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Crear Nuevo Torneo");

        LinearLayout layoutCampos = new LinearLayout(this);
        layoutCampos.setOrientation(LinearLayout.VERTICAL);
        layoutCampos.setPadding(50, 40, 50, 10);

        final EditText inputNombre = new EditText(this);
        inputNombre.setHint("Nombre del videojuego");
        layoutCampos.addView(inputNombre);

        final EditText inputFecha = new EditText(this);
        inputFecha.setHint("Fecha Límite (AAAA-MM-DD)");
        layoutCampos.addView(inputFecha);

        final EditText inputHora = new EditText(this);
        inputHora.setHint("Hora Límite (HH:MM)");
        layoutCampos.addView(inputHora);

        builder.setView(layoutCampos);

        builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String nombre = inputNombre.getText().toString().trim();
                final String fechaLim = inputFecha.getText().toString().trim();
                final String horaLim = inputHora.getText().toString().trim();

                if (!nombre.isEmpty() && !fechaLim.isEmpty() && !horaLim.isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String fechaCompletaDestino = fechaLim + " " + horaLim;

                                final boolean insertado = torneoController.registrarTorneo(nombre, "Esports", "Abierto", fechaCompletaDestino);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (insertado) {
                                            Toast.makeText(HomeActivity.this, "¡Torneo creado con éxito!", Toast.LENGTH_SHORT).show();
                                            cargarTorneosDesdeBD();
                                        } else {
                                            Toast.makeText(HomeActivity.this, "Error al guardar el torneo", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } else {
                    Toast.makeText(HomeActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }
}