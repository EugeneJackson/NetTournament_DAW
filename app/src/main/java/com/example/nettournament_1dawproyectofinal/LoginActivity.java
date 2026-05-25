package com.example.nettournament_1dawproyectofinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nettournament_1dawproyectofinal.controller.JugadorController;
import com.example.nettournament_1dawproyectofinal.model.Jugador;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private JugadorController jugadorController;
    private EditText etEmail, etPassword;
    private Button btnLogin, btnIrARegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("NetTournamentPrefs", MODE_PRIVATE);
        boolean yaEstaLogeado = prefs.getBoolean("usuarioLogeado", false);

        if (yaEstaLogeado) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        setContentView(R.layout.activity_login);

        jugadorController = new JugadorController(LoginActivity.this);

        etEmail = findViewById(R.id.etEmailLogin);
        etPassword = findViewById(R.id.etPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnIrARegistro = findViewById(R.id.btnIrARegistro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String contraseña = etPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    etEmail.setError("Introduce tu correo");
                } else if (contraseña.isEmpty()) {
                    etPassword.setError("Introduce tu contraseña");
                } else {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Jugador> listaJugadores = jugadorController.obtenerTodosLosJugadores();
                                boolean usuarioEncontrado = false;

                                if (listaJugadores != null) {
                                    for (int i = 0; i < listaJugadores.size(); i++) {
                                        Jugador j = listaJugadores.get(i);
                                        if (j.getEmail().equals(email) && j.getApodo().equals(contraseña)) {
                                            usuarioEncontrado = true;
                                            break;
                                        }
                                    }
                                }

                                final boolean finalUsuarioEncontrado = usuarioEncontrado;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (finalUsuarioEncontrado) {
                                            SharedPreferences.Editor editor = prefs.edit();
                                            editor.putBoolean("usuarioLogeado", true);
                                            editor.apply();

                                            Toast.makeText(LoginActivity.this, "¡Bienvenido de nuevo!", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Error de conexión con el servidor", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }).start();

                }
            }
        });

        btnIrARegistro.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);
        });
    }
}