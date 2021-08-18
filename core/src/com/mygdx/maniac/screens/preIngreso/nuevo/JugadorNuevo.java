package com.mygdx.maniac.screens.preIngreso.nuevo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.menu.Menu;

public class JugadorNuevo  extends Screen {

    public JugadorNuevo(final TypingManiacArcade game) {
        super(game);
        this.game.continuarPI.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.datos.setJugadorNuevo(game.nombre.getText());
                System.out.println("Welcome "+game.nombre.getText());
                game.setScreen(new Menu(game));
            }
        });
    }
    public void draw(float delta) {
        // ---------- fondo/imagen titulo ----------- //
        this.game.batch.draw(this.game.fondo3, 0, 0);
        this.game.batch.draw(this.game.tituloI,this.game.width/2-312, this.game.height-100);
        // ---------------------------- //

        // ---------- configuracion from -----------------//
        // ---- nombre ---- //
//        this.game.label.setSize(200,200);
//        this.game.label.setText("Label");
//        this.game.label.doLayout();
        //this.game.label.Actor.draw(this.game.batch,50);
        //this.game.stage4.addActor(this.game.label);
        this.game.nombre.setSize(550,300);
        this.game.nombre.setPosition(this.game.width/2-270,100);
        this.game.nombre.setAlignment(1);
        this.game.nombre.draw(this.game.batch,10);
        this.game.stage4.addActor(this.game.nombre);
        // ---- boton ---- //
        this.game.continuarPI.setSize(550,50);
        this.game.continuarPI.setPosition(this.game.width/2-270,50);
        this.game.continuarPI.draw(this.game.batch,10);
        this.game.stage4.addActor(this.game.continuarPI);
        // -----------------------------------------------//
        Gdx.input.setInputProcessor(this.game.stage4);
        game.stage4.draw();
    }
    public void update(float delta) {}
}
