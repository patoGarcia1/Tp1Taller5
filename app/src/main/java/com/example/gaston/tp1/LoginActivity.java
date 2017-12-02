package com.example.gaston.tp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button boton;
    EditText usuario;
    EditText contraseña;
    static Usuario  usuarioNuevo;
    private Context context;
    private SharedPreferences sharedPreferences;
    TextView textnombre;
    TextView textmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setContentView(R.layout.nav_header_main);

        //usuario nuevo harcodeado
        usuarioNuevo = new Usuario("pedrin", "123", "pedrito@gmail.com".toUpperCase());



        boton = (Button) findViewById(R.id.botonEntrar);
        usuario = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.contraseña);
        context = this;


        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if (!username.isEmpty() && !password.isEmpty()) {
            ingresoUsuario();
        } else {
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (isLogin(usuario.getText().toString(), contraseña.getText().toString())) {
                        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                        sharedPreferences.edit()
                                .putString("username", usuarioNuevo.getNombre().toString())
                                .putString("password", usuarioNuevo.getPassword().toString())
                                .apply();
                        ingresoUsuario();
                    }else
                    {
                        mensajeErrorLogin();
                    }


                    //ingresoUsuario(usuario,contraseña);


                }
            });




        }
    }

    //private void ingresoUsuario (EditText usuario, EditText contraseña)
    private void ingresoUsuario ()
    {
       // String usuarioString = (String)usuario.getText().toString();
        //String contraseñaString = (String)contraseña.getText().toString();


       // if(usuarioString.toUpperCase().equals(usuarioNuevo.getNombre()) && contraseñaString.equals(usuarioNuevo.getPassword()))
        //{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            mensajeBienvenido();

        //}
       // else
       // {
       //     mensajeErrorLogin();
        //}
    }

    private void mensajeBienvenido()
    {
        Toast toast1 = Toast.makeText(getApplicationContext(),"Hola "+usuarioNuevo.getNombre(),Toast.LENGTH_SHORT);
        toast1.show();
    }

    private void mensajeErrorLogin()
    {
        Toast toast1 = Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT);
        toast1.show();
    }

    public static Usuario getUsuarioNuevo()
    {
        return usuarioNuevo;
    }

    private boolean isLogin(String user, String pass) {
        return user.equals(usuarioNuevo.getNombre().toString()) && pass.equals(usuarioNuevo.getPassword().toString());
    }
}
