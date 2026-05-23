package com.example.nettournament_1dawproyectofinal;

import android.content.Intent;
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

        //controlador
        jugadorController = new JugadorController(RegistroActivity.this);

        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    etEmail.setError("El correo no puede estar vacío");
                } else if (password.isEmpty()) {
                    etPassword.setError("La contraseña no puede estar vacía");
                } else {
                    jugadorController.registrarJugador(email, new JugadorController.OnRegistroListener() {
                        @Override
                        public void onSuccess() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegistroActivity.this, "Registro completado", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegistroActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }

                        @Override
                        public void onError(Exception e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegistroActivity.this, "Error al conectar con la Base de Datos", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}