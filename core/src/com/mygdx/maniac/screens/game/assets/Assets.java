package com.mygdx.maniac.screens.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

    // SPRITES
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
    public static final int MAPA_1 = 14;
    public static final int MAPA_2 = 15;
    public static final int MAPA_3 = 16;
    public static final int MAPA_4 = 17;
    public static final int ESTANTERIA = 18;

    // Animations
    public static final int CUENTA_REGRESIVA = 100;
    public static final int ERROR_ANIMATION = 101;

    // Sounds
    public static final int KEY_PRESS = -1;
    public static final int BLOW = -2;
    public static final int FREEZE = -3;
    public static final int ERROR = -4;

    // Music
    public static final int MUSIC_1 = -100;
    public static final int MUSIC_2 = -200;
    public static final int MUSIC_3 = -300;



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
            case MAPA_1:
                spr = atlas.createSprite("mapa1");
                break;
            case MAPA_2:
                spr = atlas.createSprite("mapa2");
                break;
            case MAPA_3:
                spr = atlas.createSprite("mapa3");
                break;
            case MAPA_4:
                spr = atlas.createSprite("mapa4");
                break;
            case ESTANTERIA:
                spr = atlas.createSprite("estanteria");
                break;
            default:
                spr = new Sprite();
                break;
        }
        return spr;
    }

    public static Animation<TextureRegion> getAnimation(int animation) {
        // Return the animation selected
        Animation<TextureRegion> ani;

        if(atlas == null) {
            new Assets();
        }

        switch (animation) {
            case CUENTA_REGRESIVA:
                ani = new  Animation < TextureRegion > ( 0.06f , atlas.findRegions ( "Cuenta" ));
                break;
            case ERROR_ANIMATION:
                ani = new  Animation < TextureRegion > ( 1f/9f , atlas.findRegions ( "error" ));
                break;

            default:
                ani = new  Animation < TextureRegion > ( 0.5f , atlas.findRegions ( "Cuenta" ));
                break;
        }
        return ani;
    }

    public static Sound getSound(int sound) {
        // return the sound pass to params
        Sound sou;

        if(atlas == null) {
            new Assets();
        }

        switch (sound) {
            case KEY_PRESS:
                sou = Gdx.audio.newSound(Gdx.files.internal("sounds/keyPress.mp3"));
                break;
            case BLOW:
                sou = Gdx.audio.newSound(Gdx.files.internal("sounds/blow.mp3"));
                break;
            case FREEZE:
                sou = Gdx.audio.newSound(Gdx.files.internal("sounds/freeze.mp3"));
                break;
            case ERROR:
                sou = Gdx.audio.newSound(Gdx.files.internal("sounds/error.mp3"));
                break;
            default:
                sou = Gdx.audio.newSound(Gdx.files.internal("sounds/keyPress.mp3"));
                break;
        }
        return sou;
    }

    public static Music getMusic(int music) {
        // This method return music
        Music mus;

        if(atlas == null) {
            new Assets();
        }

        switch (music) {
            case MUSIC_1:
                mus = Gdx.audio.newMusic(Gdx.files.internal("music/music_1.mp3"));
                break;
            case MUSIC_2:
                mus = Gdx.audio.newMusic(Gdx.files.internal("music/music_2.mp3"));
                break;
            case MUSIC_3:
                mus = Gdx.audio.newMusic(Gdx.files.internal("music/music_3.mp3"));
                break;
            default:
                mus = Gdx.audio.newMusic(Gdx.files.internal("music/music_1.mp3"));
                break;
        }

        return mus;
    }
}
