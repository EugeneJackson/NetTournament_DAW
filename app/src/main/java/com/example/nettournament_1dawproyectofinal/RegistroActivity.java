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

public class RegistroActivity extends AppCompatActivity {

    private JugadorController jugadorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        jugadorController = new JugadorController(RegistroActivity.this);

        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etUsuario = findViewById(R.id.etUsuario);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String usuario = etUsuario.getText().toString().trim();
                String contraseña = etPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    etEmail.setError("El correo no puede estar vacío");
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Introduce un correo electrónico válido (ejemplo@dominio.com)");
                } else if (usuario.isEmpty()) {
                    etUsuario.setError("El apodo no puede estar vacío");
                } else if (contraseña.isEmpty()) {
                    etPassword.setError("La contraseña no puede estar vacía");
                } else {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                boolean registroExitoso = jugadorController.registrarJugador(usuario, contraseña, email);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (registroExitoso) {
                                            SharedPreferences prefs = getSharedPreferences("NetTournamentPrefs", MODE_PRIVATE);
                                            SharedPreferences.Editor editor = prefs.edit();
                                            editor.putBoolean("usuarioLogeado", true);
                                            editor.apply();

                                            Toast.makeText(RegistroActivity.this, "Registro completado", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(RegistroActivity.this, HomeActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(RegistroActivity.this, "Error al guardar en la BBDD (Datos inválidos o duplicados)", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegistroActivity.this, "Error de conexión con el servidor", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }).start();

                }
            }
        });
    }
}