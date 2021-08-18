package com.mygdx.maniac.screens.niveles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.Game;
import com.mygdx.maniac.screens.game.information.Levels;

public class Niveles extends Screen {

    public Niveles(final TypingManiacArcade game) {
        super(game);

        //botonesDisables();

        this.game.nivel1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Game(game, Levels.LEVEL_0));
            }
        });

        //if(!this.game.nivel2.isDisabled()){
            this.game.nivel2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Game(game, Levels.LEVEL_1));
                }
            });
        //}
        //if(!this.game.nivel3.isDisabled()) {
            this.game.nivel3.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Game(game, Levels.LEVEL_2));
                }
            });
        //}
    }
    public void draw(float delta) {
        //game.stage.clear();
        // ---------- fondo ----------- //
        this.game.batch.draw(this.game.fondo2, 0, 0);
        this.game.batch.draw(this.game.tituloI,this.game.width/2-312, this.game.height-100);
        // ---------------------------- //

        // ---------- configuracion botones -----------------//
        // ---- boton 1 ---- //
        this.game.nivel1.setSize(160,50);
        this.game.nivel1.setPosition(this.game.width-210,this.game.height-170);
        this.game.nivel1.draw(this.game.batch,10);
        this.game.stage3.addActor(this.game.nivel1);
        // ---- boton 2 ---- //
        this.game.nivel2.setSize(160,50);
        this.game.nivel2.setPosition(this.game.width-210,this.game.height-250);
        this.game.nivel2.draw(this.game.batch,10);
        this.game.stage3.addActor(this.game.nivel2);

        // ---- boton 3 ---- //
        this.game.nivel3.setSize(160,50);
        this.game.nivel3.setPosition(this.game.width-210,this.game.height-330);
        this.game.nivel3.draw(this.game.batch,10);
        this.game.stage3.addActor(this.game.nivel3);

        Gdx.input.setInputProcessor(this.game.stage3);
        game.stage3.draw();
        // ------------------------------------------------- //

    }
    public void update(float delta) {}
    public void botonesDisables() {
        if(this.game.jugadorOn==1){
            if(this.game.datos.getNivelActualJ1()<2){
                this.game.nivel2.setDisabled(true);
            }
            if(this.game.datos.getNivelActualJ1()<3){
                this.game.nivel3.setDisabled(true);
            }
        }
        if(this.game.jugadorOn==2){
            if(this.game.datos.getNivelActualJ2()<2){
                this.game.nivel2.setDisabled(true);
            }
            if(this.game.datos.getNivelActualJ2()<3){
                this.game.nivel3.setDisabled(true);
            }
        }
        if(this.game.jugadorOn==3){
            if(this.game.datos.getNivelActualJ3()<2){
                this.game.nivel2.setDisabled(true);
            }
            if(this.game.datos.getNivelActualJ3()<3){
                this.game.nivel3.setDisabled(true);
            }
        }
    }
}
