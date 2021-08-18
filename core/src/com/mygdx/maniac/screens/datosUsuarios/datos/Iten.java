package com.mygdx.maniac.screens.datosUsuarios.datos;

public class Iten {
    public String nombre;
    public int nivelActual;
    public int nivelDejadoAMedias;
    public String datosNivelAMedias;
    public String palabrasDejadasAMedias;

    public Iten(){
        this.nombre=null;
        this.nivelActual=-1;
        this.nivelDejadoAMedias=-1;
        this.datosNivelAMedias=null;
        this.palabrasDejadasAMedias=null;
    }
    public Iten(String nombre){
        this.nombre=nombre;
        this.nivelActual=1;
        this.nivelDejadoAMedias=1;
        this.datosNivelAMedias="vacio";
        this.palabrasDejadasAMedias="vacio";
    }
    public Iten(String nombre,int nivelDejadoAMedias, String datosNivelAMedias,String palabrasDejadasAMedias){
        this.nombre=nombre;
        this.nivelActual=1;
        this.nivelDejadoAMedias=nivelDejadoAMedias;
        this.datosNivelAMedias=datosNivelAMedias;
        this.palabrasDejadasAMedias=palabrasDejadasAMedias;
    }
    public Iten(String nombre,int nivelActual,int nivelDejadoAMedias, String datosNivelAMedias,String palabrasDejadasAMedias){
        this.nombre=nombre;
        this.nivelActual=nivelActual;
        this.nivelDejadoAMedias=nivelDejadoAMedias;
        this.datosNivelAMedias=datosNivelAMedias;
        this.palabrasDejadasAMedias=palabrasDejadasAMedias;
    }
}
