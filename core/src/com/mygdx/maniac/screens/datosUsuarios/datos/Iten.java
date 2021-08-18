package com.mygdx.maniac.screens.datosUsuarios.datos;

public class Iten {
    public String nombre;
    public int nivelActual;

    public Iten(){
        this.nombre=null;
        this.nivelActual=-1;
    }
    public Iten(String nombre){
        this.nombre=nombre;
        this.nivelActual=1;
    }
    public Iten(String nombre,int nivelActual){
        this.nombre=nombre;
        this.nivelActual=nivelActual;
    }
}
