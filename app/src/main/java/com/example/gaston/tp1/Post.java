package com.example.gaston.tp1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {

    @SerializedName("id")
    private int idPost;
    private Bitmap foto;
    private int idFoto;
    private String titulo;
    private String cuerpo;
    private String tag;
    private int puntos;
  /*  private double longitud;
    private double latitud;*/
    private ArrayList listaComentarios;
    private int contPosts=0;
    private Usuario usuarioAsignadoAlPost;

    public Post(Usuario usr, Bitmap foto, int idFoto, String titulo, String cuerpo){//, double longitud, double latitud) {
        contPosts++;
       // this.idPost = Integer.valueOf(String.valueOf(usr.getIdUsuario())+String.valueOf(contPosts));
        this.idFoto = idFoto;
        this.foto = foto;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        //this.tag = tag;
       /* this.longitud = longitud;
        this.latitud = latitud;*/
    }

    public void setUsuarioAsignadoAlPost(Usuario usuarioAsignadoAlPost) {
        this.usuarioAsignadoAlPost = usuarioAsignadoAlPost;
    }

    public Usuario getUsuarioAsignadoAlPost() {
        return usuarioAsignadoAlPost;
    }

  /*  public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }*/

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getIdPost() {
        return idPost;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String getTag() {
        return tag;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
}