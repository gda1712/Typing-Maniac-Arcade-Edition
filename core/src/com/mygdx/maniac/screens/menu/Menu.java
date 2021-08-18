package com.mygdx.maniac.screens.menu;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.niveles.Niveles;

public class Menu extends Screen{

    public Menu(final TypingManiacArcade game) {
        super(game);

        this.game.play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Niveles(game));
                //game.datos.setJugadorNuevo("Mariana palaofaf");
                //System.out.println(game.datos.getNivelActualJ2());
                //System.out.println(game.datos.getJsonReader());
                //game.setScreen(new Niveles(game));
            }
        });

        this.game.musica.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(game.musica.getText().length()==3){
                    game.musica.setText("No");
                    //game.datos.setNombre3(1,"hola");
                    //System.out.println(game.datos.getJsonReader());
                }else{
                    game.musica.setText("Yes");
                }
            }
        });
//        game.play.addCaptureListener((new ClickListener() {
//                        @Override
//            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("holaa");
//                // game.setScreen(new Niveles(game));
//            }
//        }));
//        game.play.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                System.out.println("holaa");
//            }
//        });
    }

    @Override
    public void draw(float delta) {
        //dropImage = new Texture(Gdx.files.internal("typewriter.jpg"));
        // ---------- fondo/imagen titulo ----------- //
        this.game.batch.draw(this.game.fondo1, 0, 0);

        this.game.batch.draw(this.game.tituloI,this.game.width/2-312, this.game.height-100);
        // ---------- configuracion botones -----------------//

//        this.game.table.setDebug(true);
//        this.game.table.setFillParent(true);
//        this.game.table.right().top().padRight(100).padTop(100);
//        this.game.table.draw(this.game.batch,100);

//        System.out.println("holaa");
//        game.setScreen(new Niveles(game));
        // ---- boton 1 ---- //
        this.game.play.setSize(160,50);
        this.game.play.setPosition(this.game.width-265,this.game.height-170);
        this.game.play.draw(this.game.batch,10);
        this.game.stage2.addActor(this.game.play);

       // ---- boton 2 ---- //
        this.game.arcade.setSize(160,50);
        this.game.arcade.setDisabled(true);
        this.game.arcade.setPosition(this.game.width-265,this.game.height-250);
        this.game.arcade.draw(this.game.batch,10);
        this.game.stage2.addActor(this.game.arcade);
//
//        this.game.arcade.draw(this.game.batch,20);
//        this.game.arcade.setPosition(this.game.width-120,this.game.height-100);
//        this.game.stage2.addActor(this.game.arcade);
//        Gdx.input.setInputProcessor( this.game.stage2);
        // ------------------------------------------------- //
        // -------------------- opciones boton--------------------- //

        this.game.musica.setSize(40,30);
        this.game.musica.setPosition(this.game.width-213,100);
        this.game.musica.draw(this.game.batch,10);
        this.game.stage2.addActor(this.game.musica);

        // ---------------------------------------------------- //
        // -------------------- cargar botones --------------------- //
        Gdx.input.setInputProcessor(this.game.stage2);
        game.stage2.draw();
        // ------------------------------------------------------ //
        // -------------------- opciones texto--------------------- //
        this.game.opciones.draw(this.game.batch, "Musica:", this.game.width-265,120);
        this.game.opciones.setColor(Color.WHITE);
    }
    public void update(float delta) {
        game.stage.act(delta);
    }
}
