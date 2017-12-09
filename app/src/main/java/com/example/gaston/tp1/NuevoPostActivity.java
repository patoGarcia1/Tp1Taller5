package com.example.gaston.tp1;

import android.content.Context;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class NuevoPostActivity extends AppCompatActivity {


    private ImageView imageView;
    private Button botonPostear;
    private EditText titulo;
    private EditText cuerpo;
    Bitmap imagen;
    private int imagenId;
    //private Location location;
   // int permissionCheck;
   // int permissionCheck2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_post);



        botonPostear = (Button)findViewById(R.id.botonPostear);
        imageView = (ImageView)findViewById(R.id.foto);

        Bundle extras = getIntent().getExtras();
        imagen = (Bitmap) extras.get("imagen");
        imageView.setImageBitmap(imagen);

      /*  permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 225);
        }
        permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (permissionCheck2 != PackageManager.PERMISSION_GRANTED)
        {
            Log.i("Mensaje", "No se tiene permiso para obtener información de contactos.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 225);
        }*/

        titulo = (EditText)findViewById(R.id.titulo);
        cuerpo = (EditText)findViewById(R.id.cuerpo);

        botonPostear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


           /*     LocationManager mLockManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                location = mLockManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                final double latitude = location.getLatitude();
                final double longitude = location.getLongitude();*/

                crearNuevoPost();//latitude,longitude);

                Intent intent = new Intent(NuevoPostActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private void crearNuevoPost()//double lat, double lon)
    {
        String tituloString = (String)titulo.getText().toString();
        String cuerpoString = (String)cuerpo.getText().toString();
        //int imagenId =(int)imagenId.getInt();

        Post nuevoPost = new Post(LoginActivity.getUsuarioNuevo(),imagen,imagenId,tituloString,cuerpoString);//,lat,lon);
        MainActivity.getListaPosts().add(nuevoPost);
    }

}
