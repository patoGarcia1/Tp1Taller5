package com.example.gaston.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {

    Button btnLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        String postSerializado = extras.getString("post");
        Post post = new Gson().fromJson(postSerializado, Post.class);

        ImageView foto = (ImageView) findViewById(R.id.foto);
        foto.setImageResource(post.getIdFoto());
        TextView nombreTv = (TextView) findViewById(R.id.titulo);
        nombreTv.setText(post.getTitulo());
        TextView precioTv = (TextView) findViewById(R.id.cuerpo);
        precioTv.setText(post.getCuerpo());


        btnLogo = (Button) findViewById(R.id.btnLogo);

        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}