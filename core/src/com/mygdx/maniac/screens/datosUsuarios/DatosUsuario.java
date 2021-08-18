package com.mygdx.maniac.screens.datosUsuarios;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.*;
import com.mygdx.maniac.screens.datosUsuarios.datos.Iten;

public class DatosUsuario {
    private JsonReader json;
    private static JsonValue base;

    public DatosUsuario() {
        this.json = new JsonReader();
        //this.base = this.json.parse(Gdx.files.internal("datosUsuario/datosUsuario.json"));
        this.base = this.json.parse(Gdx.files.local("salida.json"));
    }

    public String getJsonReader() {
        if(this.base!=null){
            return this.base.toString();
        }else{
            return "";
        }
    }

    public String[] getTodosLosNombres() {
        String nombres[] = new String[this.base.size()];
        for (int i=0; i<this.base.size(); i++){
            String[] split = this.base.get(i).get(0).toString().split(":");
            if(split==null){
                nombres[i]="Aun no Existe Jugador";
            }else{
                nombres[i]=split[1];
            }
        }
        return nombres;
    }

    public void setJugadorNuevo(String nombre) {
        try {
            Json json = new Json();
            Iten iten = new Iten(nombre);
            String cad = json.prettyPrint(iten);

            String elJson="[";
            for (int i=0; i<this.base.size(); i++){
                if(elJson!="["){
                    elJson=elJson+","+this.base.get(i).toString();
                }else{
                    elJson=elJson+this.base.get(i).toString();
                }
            }
            if(elJson!="["){
                elJson=elJson+","+cad+"]";
            }else{
                elJson=elJson+cad+"]";
            }
            FileHandle file= Gdx.files.local("salida.json");
            Gdx.files.local("vacio.json").copyTo(file);
            file.writeString(elJson,true);
            this.base = this.json.parse(Gdx.files.local("salida.json"));
            //System.out.println("nombre1:"+this.base.get(0).get(0).toString().split(":")[1]);
            //System.out.println(file);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getNombre(int i) {
        if(this.base.get(i)!=null){
            String[] split = this.base.get(i).get(0).toString().split(":");
            if(split==null){
                return "";
            }else{
                return split[1].toString();
            }
        }else{
            return "Aun no Existe Jugador";
        }
    }
    public String getNombre1() {
        return getNombre(0);
    }
    public String getNombre2() {
        return getNombre(1);
    }
    public String getNombre3() {
        return getNombre(2);
    }

    private int getNivelActual(int i) {
//        System.out.println(this.base.get(i).get(1).toString().split(":")[1]);
//        return 0;
        if(this.base.get(i)!=null){
            String[] split = this.base.get(i).get(1).toString().split(": ");
            if(split==null){
                return 1;
            }else{
                return Integer.parseInt(split[1]);
            }
        }else{
            return 1;
        }
    }
    public int getNivelActualJ1() {
        return getNivelActual(0);
    }
    public int getNivelActualJ2() {
        return getNivelActual(1);
    }
    public int getNivelActualJ3() {
        return getNivelActual(2);
    }
}


