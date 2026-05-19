package com.example.nettournament_1dawproyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nettournament_1dawproyectofinal.dao.JugadorDAO;
import com.example.nettournament_1dawproyectofinal.model.Jugador;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                    Jugador nuevojugador = new Jugador();
                    nuevojugador.setNombre(email);
                    nuevojugador.setApodo(email);
                    nuevojugador.setEmail(email);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JugadorDAO jugadorDAO = new JugadorDAO(RegisterActivity.this);
                                jugadorDAO.insertar(nuevojugador);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegisterActivity.this, "Registro completado", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegisterActivity.this, "Error al conectar con la Base de Datos", Toast.LENGTH_SHORT).show();

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