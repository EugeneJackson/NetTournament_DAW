package com.example.nettournament_1dawproyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nettournament_1dawproyectofinal.controller.JugadorController;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin, btnIrARegistro;
    private JugadorController jugadorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializamos el controlador pasándole el contexto
        jugadorController = new JugadorController(this);

        // Inicializamos los componentes de la vista
        etEmail = findViewById(R.id.etEmail); // REVISAR: Asegúrate de que estos IDs coinciden con tu XML
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnIrARegistro = findViewById(R.id.btnIrARegistro);

        // 1. Botón de Iniciar Sesión (Con el puente simulado)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    etEmail.setError("Introduce tu correo");
                } else if (password.isEmpty()) {
                    etPassword.setError("Introduce tu contraseña");
                } else {
                    jugadorController.iniciarSesion(email, password, new JugadorController.OnLoginListener() {
                        @Override
                        public void onSuccess() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "¡Bienvenido de nuevo!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }

                        @Override
                        public void onInvalidCredentials() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            }
        });

        // 2. Botón para navegar a la pantalla de registro
        btnIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}