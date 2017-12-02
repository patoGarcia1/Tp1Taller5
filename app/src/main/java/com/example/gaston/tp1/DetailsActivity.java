package com.example.gaston.tp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        String postSerializado = extras.getString("post");
        Post post = new Gson().fromJson(postSerializado, Post.class);

        //ImageView fotoIv = (ImageView) findViewById(R.id.foto);
        //fotoIv.setImageResource(post.getFotoId());
        TextView nombreTv = (TextView) findViewById(R.id.titulo);
        nombreTv.setText(post.getTitulo());
        TextView precioTv = (TextView) findViewById(R.id.cuerpo);
        precioTv.setText(post.getCuerpo());
    }
}