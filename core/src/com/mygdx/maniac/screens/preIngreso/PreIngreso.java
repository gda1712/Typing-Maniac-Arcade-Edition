package com.mygdx.maniac.screens.preIngreso;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonReader;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.menu.Menu;
import com.mygdx.maniac.screens.niveles.Niveles;
import com.mygdx.maniac.screens.preIngreso.nuevo.JugadorNuevo;
import org.w3c.dom.*;

import java.awt.*;

public class PreIngreso extends Screen{

    public PreIngreso(final TypingManiacArcade game) {
        super(game);

        obtenerNombres();
        this.game.jugadore1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(game.jugadore1.getName()=="Nueva partida"){
                    game.jugadorOn=1;
                    System.out.println("Oh veo que eres nuev@ aqui, Welcome");
                    game.setScreen(new JugadorNuevo(game));
                }else{
                    game.jugadorOn=1;
                    System.out.println("Welcome "+game.jugadore1.getName());
                    game.setScreen(new Menu(game));
                }
            }
        });
        if(!(this.game.datos.getNombre1()=="Aun no Existe Jugador")){
            this.game.jugadore2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(game.jugadore2.getName()=="Nueva partida"){
                        game.jugadorOn=2;
                        System.out.println("Oh veo que eres nuev@ aqui, Welcome");
                        game.setScreen(new JugadorNuevo(game));
                    }else{
                        game.jugadorOn=2;
                        System.out.println("Welcome "+game.jugadore2.getName());
                        game.setScreen(new Menu(game));
                    }
                }
            });
        }
        if(!(this.game.datos.getNombre2()=="Aun no Existe Jugador")) {
            this.game.jugadore3.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (game.jugadore3.getName() == "Nueva partida") {
                        game.jugadorOn = 3;
                        System.out.println("Oh veo que eres nuev@ aqui, Welcome");
                        game.setScreen(new JugadorNuevo(game));
                    } else {
                        game.jugadorOn = 3;
                        System.out.println("Welcome " + game.jugadore3.getName());
                        game.setScreen(new Menu(game));
                    }
                }
            });
        }
    }
    public void draw(float delta) {
        // ---------- fondo/imagen titulo ----------- //
        this.game.batch.draw(this.game.fondo3, 0, 0);
        this.game.batch.draw(this.game.tituloI,this.game.width/2-312, this.game.height-100);
        // ---------------------------- //
        this.game.tituloPI.draw(this.game.batch, "PARTIDAS GUARDADAS:", this.game.width/2-70,this.game.height-120);
        this.game.tituloPI.setColor(Color.WHITE);
        this.game.tituloPI.setOwnsTexture(false);
        // ---------- configuracion botones -----------------//

        // ---- boton 1 ---- //
        this.game.jugadore1.setSize(550,100);
        this.game.jugadore1.setPosition(this.game.width/2-270,250);
        this.game.jugadore1.draw(this.game.batch,10);
        this.game.stage.addActor(this.game.jugadore1);
        // ---- boton 2 ---- //
        this.game.jugadore2.setSize(550,100);
        if(this.game.datos.getNombre1()=="Aun no Existe Jugador"){
            this.game.jugadore2.setDisabled(true);
        }
        this.game.jugadore2.setPosition(this.game.width/2-270,150);
        this.game.jugadore2.draw(this.game.batch,10);
        this.game.stage.addActor(this.game.jugadore2);
        // ---- boton 3 ---- //
        this.game.jugadore3.setSize(550,100);
        if(this.game.datos.getNombre2()=="Aun no Existe Jugador"){
            this.game.jugadore3.setDisabled(true);
        }
        this.game.jugadore3.setPosition(this.game.width/2-270,50);
        this.game.jugadore3.draw(this.game.batch,10);
        this.game.stage.addActor(this.game.jugadore3);
        // --------------------------------------------------- //
        Gdx.input.setInputProcessor(this.game.stage);
        game.stage.draw();
    }
    public void update(float delta) {}

    private void obtenerNombres() {
        if(this.game.datos.getNombre1()!="Aun no Existe Jugador"){
            this.game.jugadore1.setName(this.game.datos.getNombre1());
            this.game.jugadore1.setText(this.game.datos.getNombre1());
        }
        if(this.game.datos.getNombre2()!="Aun no Existe Jugador"){
            this.game.jugadore2.setName(this.game.datos.getNombre2());
            this.game.jugadore2.setText(this.game.datos.getNombre2());
        }
        if(this.game.datos.getNombre3()!="Aun no Existe Jugador"){
            this.game.jugadore3.setName(this.game.datos.getNombre3());
            this.game.jugadore3.setText(this.game.datos.getNombre3());
        }
    }
}
