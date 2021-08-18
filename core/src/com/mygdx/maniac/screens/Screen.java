package com.mygdx.maniac.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.maniac.TypingManiacArcade;

public abstract class Screen extends InputAdapter implements com.badlogic.gdx.Screen {

    /* Father class, in this class i declare the scheme to the screens*/
<<<<<<< HEAD
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 512;
=======
    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
>>>>>>> Gabriel

    public static final float WORD_WIDTH = Gdx.graphics.getWidth() / 100.f;
    public static final float WORD_HEIGHT = Gdx.graphics.getHeight() / 100.f;

    protected TypingManiacArcade game;

    protected OrthographicCamera cameraUI, cameraBox2d;

    public Screen(TypingManiacArcade game) {
        // Constructor

        this.game = game;

<<<<<<< HEAD
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.camera.position.set(SCREEN_WIDTH/2,SCREEN_HEIGHT/2,0);
        this.camera.update();
=======
        this.cameraUI = new OrthographicCamera();
        this.cameraUI.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.cameraUI.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);

        this.cameraBox2d = new OrthographicCamera();
        this.cameraBox2d.setToOrtho(false, WORD_WIDTH, WORD_HEIGHT);
        this.cameraBox2d.position.set(WORD_WIDTH / 2, WORD_HEIGHT / 2, 0);

>>>>>>> Gabriel
        Gdx.input.setInputProcessor(this);

    }

    public void update(float delta){}

    //-------------------------------------SCREEN METHODS------------------------------
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /* This method render te screen using delta time*/
        this.update(delta);

        // Clean screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
<<<<<<< HEAD
        this.update(delta);
        this.camera.update();
=======

        this.cameraBox2d.update();
        this.cameraUI.update();
>>>>>>> Gabriel

        // Projection camera in screen
        this.game.batch.setProjectionMatrix(cameraUI.combined);


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
    public abstract void update(float delta);

}
