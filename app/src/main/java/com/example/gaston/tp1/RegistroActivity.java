package com.example.gaston.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    EditText etUser;
    EditText etEmail;
    EditText etPass;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

    etUser = (EditText) findViewById(R.id.etUser);
    etEmail = (EditText) findViewById(R.id.etEmail);
    etPass = (EditText) findViewById(R.id.etPass);
    bt1 = (Button) findViewById(R.id.bt1);


    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        /*
        *
        * Espacio para meter el user en la API Falsa
        *
         */

            Intent intent = new Intent(RegistroActivity.this, com.example.gaston.tp1.LoginActivity.class);
            startActivity(intent);
        }
    });


    }
}
