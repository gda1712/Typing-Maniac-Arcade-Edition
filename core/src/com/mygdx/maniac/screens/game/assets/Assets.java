package com.mygdx.maniac.screens.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    public static final int CAMPO_TEXTO = 0;
    public static final int PARED = 1;
    public static final int BARRA_TEXTO_DORADA = 2;
    public static final int HOJA_TEXTO_PERGAMINO = 3;
    public static final int ESQUINA_PUNTUACION = 4;
    public static final int MUSICA_BOTON_DESACTIVADO = 5;
    public static final int MUSICA_BOTON_ACTIVADO = 6;
    public static final int SONIDO_BOTON_DESACTIVADO = 7;
    public static final int SONIDO_BOTON_ACTIVADO = 8;
    public static final int MAQUINA_ESCRIBIR = 9;
    public static final int PERGAMINO = 10;
    public static final int MAQUINA_ESCRIBIR_HOJA = 11;
    public static final int PRESS_ENTER = 12;
    public static final int ESCRITORIO = 13;
    public static final int MAPA_ILUMINADO = 14;

    private static TextureAtlas atlas;
    public Assets() {
        atlas = new TextureAtlas(Gdx.files.internal("images/pack.atlas"));
    }

    public static Sprite getSprite(int sprite) {
        // Return the sprite using the number
        Sprite spr;

        if(atlas == null) {
            new Assets();
        }

        switch (sprite) {
            case CAMPO_TEXTO:
                spr = atlas.createSprite("Campo_texto");
                break;
            case PARED:
                spr = atlas.createSprite("Pared");
                break;
            case BARRA_TEXTO_DORADA:
                spr = atlas.createSprite("Barra_texto_dorada");
                break;
            case HOJA_TEXTO_PERGAMINO:
                spr = atlas.createSprite("Hoja_texto_pergamino");
                break;
            case ESQUINA_PUNTUACION:
                spr = atlas.createSprite("esquina_puntuacion");
                break;
            case MUSICA_BOTON_DESACTIVADO:
                spr = atlas.createSprite("musica_boton_desactivado");
                break;
            case MUSICA_BOTON_ACTIVADO:
                spr = atlas.createSprite("musica_boton");
                break;
            case SONIDO_BOTON_DESACTIVADO:
                spr = atlas.createSprite("sonido_boton_desactivado");
                break;
            case SONIDO_BOTON_ACTIVADO:
                spr = atlas.createSprite("sonido_boton");
                break;
            case MAQUINA_ESCRIBIR:
                spr = atlas.createSprite("maquina_escribir");
                break;
            case PERGAMINO:
                spr = atlas.createSprite("pergamino");
                break;
            case MAQUINA_ESCRIBIR_HOJA:
                spr = atlas.createSprite("maquina_escribir_hoja");
                break;
            case PRESS_ENTER:
                spr = atlas.createSprite("press_enter");
                break;
            case ESCRITORIO:
                spr = atlas.createSprite("escritorio");
                break;
            case MAPA_ILUMINADO:
                spr = atlas.createSprite("mapa_iluminado");
                break;
            default:
                spr = new Sprite();
                break;
        }
        return spr;
    }
}
