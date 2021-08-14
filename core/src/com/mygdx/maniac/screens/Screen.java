package com.mygdx.maniac.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.maniac.TypingManiacArcade;

public abstract class Screen extends InputAdapter implements com.badlogic.gdx.Screen {

    /* Father class, in this class i declare the scheme to the screens*/
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    public static final float WORD_WIDTH = 8.f;
    public static final float WORD_HEIGHT = 6.f;


    protected TypingManiacArcade game;

    protected OrthographicCamera camera;

    public Screen(TypingManiacArcade game) {
        // Constructor

        this.game = game;

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        Gdx.input.setInputProcessor(this);
    }

    //-------------------------------------SCREEN METHODS------------------------------
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /* This method render te screen using delta time*/

        // Clean screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.camera.update();

        // Projection camera in screen
        this.game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        // Draw objects
        this.draw(delta);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public abstract void draw(float delta);

}
