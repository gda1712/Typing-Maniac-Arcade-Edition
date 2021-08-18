package com.mygdx.maniac.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.assets.Assets;
import com.mygdx.maniac.screens.niveles.Niveles;
import com.mygdx.maniac.screens.preIngreso.PreIngreso;

public class GameFinished extends Screen {

    private Sprite pergamino;
    private Sprite background;
    private Sprite pressEnter;

    private BitmapFont fontTitle;

    private BitmapFont fontStatistics;

    String textTitle;

    private int wrongWords;
    private int rightWords;
    private int score;

    public GameFinished(TypingManiacArcade game, int wrongWords, int rightWords, int score, boolean win) {
        // This class show the score of the game
        super(game);

        this.wrongWords = wrongWords;
        this.rightWords = rightWords;
        this.score = score;

        if(win == true){
            this.textTitle = "NIVEL COMPLETADO";
            this.background = Assets.getSprite(Assets.MAPA_3);
            this.background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            this.background.setPosition(0, 0);
            if(this.game.jugadorOn == 1) {
                this.game.datos.setNivel(this.game.jugadorOn, this.game.datos.getNivelActualJ1());
            }
            if(this.game.jugadorOn == 2) {
                this.game.datos.setNivel(this.game.jugadorOn, this.game.datos.getNivelActualJ2());
            }
            if(this.game.jugadorOn == 3) {
                this.game.datos.setNivel(this.game.jugadorOn, this.game.datos.getNivelActualJ3());
            }

        }

        else{
            this.textTitle = "NIVEL PERDIDO";
            this.background = Assets.getSprite(Assets.MAPA_2);
            this.background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            this.background.setPosition(0, 0);
        }


        this.pergamino = Assets.getSprite(Assets.PERGAMINO);
        this.pergamino.setSize(300, 400);
        this.pergamino.setPosition((SCREEN_WIDTH / 2) - 400, (SCREEN_HEIGHT / 2.f) - this.pergamino.getHeight() / 2.f);



        this.pressEnter = Assets.getSprite(Assets.PRESS_ENTER);
        this.pressEnter.setSize(200, 20);
        this.pressEnter.setPosition((SCREEN_WIDTH / 2.f) - 350.f, ((SCREEN_HEIGHT / 2.f) - this.pergamino.getHeight() / 2.f) + 20.f);


        // Set fonts
        this.fontTitle = new BitmapFont();
        this.fontTitle.getData().setScale(1.4f, 1.4f);
        this.fontTitle.setColor(Color.GOLDENROD);

        this.fontStatistics = new BitmapFont();
        this.fontStatistics.setColor(Color.ROYAL);
    }

    @Override
    public void draw(float delta) {

        this.background.draw(this.game.batch);
        this.pergamino.draw(this.game.batch);

        this.fontTitle.draw(this.game.batch, this.textTitle, this.pergamino.getX() + 55, (this.pergamino.getY() + this.pergamino.getHeight()) - 50);

        this.fontStatistics.draw(this.game.batch, "Score: " + this.score,this.pergamino.getX() + 55, (this.pergamino.getY() + this.pergamino.getHeight()) - 100);
        this.fontStatistics.draw(this.game.batch, "P. Error: " + this.wrongWords,this.pergamino.getX() + 55, (this.pergamino.getY() + this.pergamino.getHeight()) - 150);
        this.fontStatistics.draw(this.game.batch, "P. Correctas: " + this.rightWords,this.pergamino.getX() + 55, (this.pergamino.getY() + this.pergamino.getHeight()) - 200);

        this.pressEnter.draw(this.game.batch);
    }

    public void update(float delta) {
        // Update

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            this.game.setScreen(new Niveles(this.game));
        }
    }
}
