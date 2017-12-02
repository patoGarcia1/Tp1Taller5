package com.example.gaston.tp1;

/**
 * Created by Pato on 1/12/2017.
 */

//Interfaz que voy a usar para implementar los callbacks del server
public interface OnSuccessCallback {

    //Este metodo es el unico que se implementara, la idea es que como parametro entre la respuesta
    // del proceso asincronico quwe se realizo (en nuestro caso la llamada a la API)
    public void execute(Object body);
}