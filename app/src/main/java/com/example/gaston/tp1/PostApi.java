package com.example.gaston.tp1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pato on 1/12/2017.
 */

public interface PostApi {


    //Interfaz que lista los metodos disponibles para ser consultados de la API

        @GET("posts") //Verbo HTTP y nombre del metodo de la API
        public Call<List<Post>> getPost(); //El return type define como sera parseado automaticamente el response

}
