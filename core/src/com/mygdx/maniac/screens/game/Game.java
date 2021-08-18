package com.mygdx.maniac.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.animation.Error;
import com.mygdx.maniac.screens.game.assets.Assets;
import com.mygdx.maniac.screens.game.information.Levels;
import com.mygdx.maniac.screens.game.objects.Floor;
import com.mygdx.maniac.screens.game.objects.Powers;
import com.mygdx.maniac.screens.game.objects.Word;
import com.mygdx.maniac.screens.game.objects.Writer;
import com.mygdx.maniac.screens.niveles.Niveles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Game extends Screen implements ContactListener, ActionListener {

    private Sprite background, bookStand;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Writer writer;
    private ArrayList <Word> words;

    private Levels level;
    private Timer timer;

    private Floor wordsFloor, powerFloor;

    public final static float DEFAULT_GRAVITY = -.5f;

    // Set the initial value to wordToDelete
    private final static int DEFAULT_WORLD_TO_DELETE = -1;
    private final static int WORD_WRITE = 1, WORD_COLLISION_FLOOR = 2;

    private int wordToDelete;

    private boolean gameStop;
    private TextButton saveAndExit;

    // This is the number of the printed words (in total game)
    private int wordsOut;

    // This is the number of the words no writed and writed
    private int wrongWords;
    private int rightWords;
    private int score;

    private float stateTime;

    private Sound errorSound;

    private BitmapFont fontWords;
    private BitmapFont fontPause;

    private ArrayList<Error> animationsError;

    private ArrayList <Powers> powers;

    public Game(final TypingManiacArcade game, int nvl, int wrongWords, int rightWords, int score, String words,boolean isLevelStoped) {
        super(game);



        // Create the world
        this.world = new World(new Vector2(0, DEFAULT_GRAVITY), false);
        this.b2dr = new Box2DDebugRenderer();

        this.writer = new Writer();
        this.level = new Levels(nvl);
        this.words = new ArrayList<Word>();

        this.gameStop = false;
        this.fontWords = new BitmapFont();
        this.fontPause = new BitmapFont();
        this.fontPause.setColor(Color.BLACK);
        this.fontPause.getData().setScale(2.5f, 2.5f);

        this.saveAndExit = new TextButton("Guardar y salir", this.game.skin);
        this.saveAndExit.setPosition(SCREEN_WIDTH / 2, (SCREEN_HEIGHT / 2) - 90);

        this.saveAndExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                game.setScreen(new Niveles(game));
            }
        });

        // Inicializate the sprite
        this.background = Assets.getSprite(Assets.MAPA_1);
        this.background.setPosition(0, 0);
        this.background.setSize(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);

        this.bookStand = Assets.getSprite(Assets.ESTANTERIA);
        this.bookStand.setPosition(this.SCREEN_WIDTH - 170, 182);
        this.bookStand.setSize( 140, 100);

        this.wordsOut = 0;
        this.wordToDelete = DEFAULT_WORLD_TO_DELETE;

        // Set the initial values
        this.wrongWords = wrongWords;
        this.rightWords = rightWords;
        this.score = score;
        this.animationsError = new ArrayList<Error>();

        // Timer animation
        this.stateTime = 0.f;

        // Inicializate the floor
        this.wordsFloor = new Floor(Floor.WORDS_FLOOR, this.world);
        this.powerFloor = new Floor(Floor.POWERS_FLOOR, this.world);

        // Inicializate the words
        this.timer = new Timer(this.level.getDepartureTime(), this);

        // Inicializate the powers
        this.powers = new ArrayList<>();

        // Inicializate the contact
        this.world.setContactListener(this);

        this.errorSound = Assets.getSound(Assets.ERROR);

        this.timer.start();
    }

    public Game(final TypingManiacArcade game, int nvl) {

        super(game);

        // Create the world
        this.world = new World(new Vector2(0, DEFAULT_GRAVITY), false);
        this.b2dr = new Box2DDebugRenderer();

        this.writer = new Writer();
        this.level = new Levels(nvl);
        this.words = new ArrayList<Word>();

        this.gameStop = false;
        this.fontWords = new BitmapFont();
        this.fontPause = new BitmapFont();
        this.fontPause.setColor(Color.BLACK);
        this.fontPause.getData().setScale(2.5f, 2.5f);

        this.saveAndExit = new TextButton("Guardar y salir", this.game.skin);
        this.saveAndExit.setPosition(SCREEN_WIDTH / 2, (SCREEN_HEIGHT / 2) - 90);

        this.saveAndExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                game.setScreen(new Niveles(game));
            }
        });

        // Inicializate the sprite
        this.background = Assets.getSprite(Assets.MAPA_1);
        this.background.setPosition(0, 0);
        this.background.setSize(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);

        this.bookStand = Assets.getSprite(Assets.ESTANTERIA);
        this.bookStand.setPosition(this.SCREEN_WIDTH - 170, 182);
        this.bookStand.setSize( 140, 100);

        this.wordsOut = 0;
        this.wordToDelete = DEFAULT_WORLD_TO_DELETE;

        // Set the initial values
        this.wrongWords = 0;
        this.rightWords = 0;
        this.score = 0;
        this.animationsError = new ArrayList<Error>();

        // Timer animation
        this.stateTime = 0.f;

        // Inicializate the floor
        this.wordsFloor = new Floor(Floor.WORDS_FLOOR, this.world);
        this.powerFloor = new Floor(Floor.POWERS_FLOOR, this.world);

        // Inicializate the words
        this.timer = new Timer(this.level.getDepartureTime(), this);

        // Inicializate the powers
        this.powers = new ArrayList<>();

        // Inicializate the contact
        this.world.setContactListener(this);

        this.errorSound = Assets.getSound(Assets.ERROR);

        this.timer.start();
    }

    public World getWorld() {
        return world;
    }

    public Box2DDebugRenderer getB2dr() {
        return b2dr;
    }

    public ArrayList<Word> getWords() {
        return words;
    }


    @Override
    public void update(float delta) {
        // This method update the logic game
        world.step(1 / 60.f, 6, 2);

        // Verify the animation error
        for(int i = 0; i < this.animationsError.size(); i++) {
            if(this.animationsError.get(i).isAnimationFinished()) {
                this.animationsError.remove(i);
            }
        }
        this.stateTime += delta;

        // Verify and delete words if this collision with the floor
        if(this.wordToDelete != DEFAULT_WORLD_TO_DELETE) {
            this.removeWord(this.wordToDelete, WORD_COLLISION_FLOOR);
            this.wordToDelete = DEFAULT_WORLD_TO_DELETE;
            if(this.score >= 100)
                this.score -= 100;
        }

        // Exit the game
        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && this.gameStop == true) {
             String datosNvl =  new String();
             datosNvl = Integer.toString(this.score) + "-" + Integer.toString(this.wrongWords) + "-" + Integer.toString(this.rightWords);


            String w = new String();

            for(int i = 0; i < this.words.size(); i++) {
                w += this.words.get(i).getWord();
                if(i < this.words.size() - 1)
                w += "-";
            }
            if(this.game.jugadorOn == 1) {
                this.game.datos.setNivelAMedias2(this.game.jugadorOn, this.game.datos.getNivelActualJ1(), this.level.getActualLevel(), datosNvl, w);
                this.game.setScreen(new Niveles(this.game));
            }
            if(this.game.jugadorOn == 2) {
                this.game.datos.setNivelAMedias2(this.game.jugadorOn, this.game.datos.getNivelActualJ2(), this.level.getActualLevel(), datosNvl, w);
                this.game.setScreen(new Niveles(this.game));
            }
            if(this.game.jugadorOn == 3) {
                this.game.datos.setNivelAMedias2(this.game.jugadorOn, this.game.datos.getNivelActualJ3(), this.level.getActualLevel(), datosNvl, w);
                this.game.setScreen(new Niveles(this.game));
            }

        }

        // If the user prees esc pause
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {

            if(this.gameStop == false) {
                this.world.setGravity(new Vector2(0, 0));

                this.timer.stop();
                for(int i = 0; i < this.words.size(); i++) {
                    this.words.get(i).getBody().setLinearVelocity(0, 0);
                }
                this.gameStop = true;
                this.game.pMusica.pause();
            }

            else if(this.gameStop == true) {
                this.world.setGravity(new Vector2(0, DEFAULT_GRAVITY));

                this.timer.start();
                for(int i = 0; i < this.words.size(); i++) {
                    this.words.get(i).getBody().setLinearVelocity(0, 0);
                }
                this.gameStop = false;
                this.game.pMusica.play();
            }

        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            // Comprobate what word is writer
            boolean foundWord = false;

            for(int i = 0; i < this.words.size(); i++) {
                if(this.words.get(i).getWord().compareToIgnoreCase(this.writer.getWord()) == 0) {
                    this.removeWord(i, WORD_WRITE);
                    this.score += 100;
                    foundWord = true;
                }
            }

            // Comprobate what power is writer
            for(int i = 0; i < this.powers.size(); i++) {
                if(this.powers.get(i).getPowerName().compareToIgnoreCase(this.writer.getWord()) == 0) {
                    this.writer.cleanWord();
                    this.powers.get(i).activate();
                    this.world.destroyBody(this.powers.get(i).getBody());

                    this.powers.remove(i);
                    foundWord = true;
                }
            }

            if(foundWord == false) {
                this.errorSound.play();
                if(this.score >= 50)
                    this.score -= 50;
                this.writer.cleanWord();
            }


        }
        // Verify the incorrect words
        if(this.wrongWords > this.level.getNumberOfWords() / 2) {
            this.game.setScreen(new GameFinished(this.game, this.wrongWords, this.rightWords, this.score, false));
        }
        else if(this.wrongWords + this.rightWords == this.level.getNumberOfWords()) {
            this.game.setScreen(new GameFinished(this.game, this.wrongWords, this.rightWords, this.score, true));
        }
    }


    private void removeWord(int index, int typeCollision) {
        // Remove a word in the array
        if(this.world.isLocked())
            return;

        this.world.destroyBody(this.words.get(index).getBody());
        this.words.remove(index);

        if(typeCollision == WORD_WRITE) {
            this.rightWords += 1;
            this.writer.cleanWord();
        }

        if(typeCollision == WORD_COLLISION_FLOOR)
            this.wrongWords += 1;
    }

    @Override
    public void draw(float delta) {
       // this.game.font.draw(this.game.batch, "Hola mundo", 200, 200);

        this.background.draw(this.game.batch);

        // pause
        if(this.gameStop == true) {
            this.fontPause.draw(this.game.batch, "PAUSA", SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
            this.saveAndExit.draw(this.game.batch, 1

            );
            game.stage2.addActor(this.saveAndExit);
        }

        // Draw the errors
        for(int i = 0; i < this.animationsError.size(); i++) {
            this.animationsError.get(i).draw(this.game.batch, delta);
        }

        // Draw the world
        for(int i = 0; i < this.words.size(); i++) {
            this.words.get(i).drawText(this.fontWords, this.game.batch);
        }

        // Draw the powers
        for(int i = 0; i < this.powers.size(); i++)
            this.powers.get(i).drawText(this.fontWords, this.game.batch);

        // Draw the bookStand
        this.bookStand.draw(this.game.batch);

        // Draw the game information
        this.game.font.draw(this.game.batch, "Errors: " + this.wrongWords, 50, 480);
        this.game.font.draw(this.game.batch, "Rigth Words: " + this.rightWords, 50, 460);
        this.game.font.draw(this.game.batch, "Score: " + this.score, 50, 440);

        this.writer.drawText(this.game.batch);
        this.game.batch.setProjectionMatrix(cameraBox2d.combined);
        //this.b2dr.render(this.world, this.cameraBox2d.combined);

    }

    @Override
    public void dispose() {
        // Clean
        super.dispose();
        this.world.dispose();
        this.b2dr.dispose();
    }



    //-------------------------------------------INPUT METHODS----------------------------

    @Override
    public boolean keyDown(int keycode) {
        this.writer.update();
        return super.keyDown(keycode);
    }

    //--------------------------------------------CONTACT METHODS-------------------------

    @Override
    public void beginContact(Contact contact) {
            Body bodyA = contact.getFixtureA().getBody();
            Body bodyB = contact.getFixtureB().getBody();

            for(int i  = 0; i < this.words.size(); i++) {
                // I verify the collisions
                if(contact.getFixtureB().getBody() == this.words.get(i).getBody() && contact.getFixtureA().getBody() == this.wordsFloor.getBody()) {
                    this.wordToDelete = i;
                    this.errorSound.play();
                    this.animationsError.add(new Error(((int)(contact.getFixtureB().getBody().getPosition().x) * 100) + 40, (int)(contact.getFixtureB().getBody().getPosition().y) * 100));
                }
                else if(contact.getFixtureA().getBody() == this.words.get(i).getBody() && contact.getFixtureB().getBody() == this.wordsFloor.getBody()) {
                    this.wordToDelete = i;
                    this.errorSound.play();
                    // Add the error in the position collision
                    this.animationsError.add(new Error(((int)(contact.getFixtureB().getBody().getPosition().x) * 100) + 40, (int)(contact.getFixtureA().getBody().getPosition().y) * 100));
                }
            }
            System.out.println(this.animationsError.size());
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }


    //------------------------------TIMER-----------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        // Timer, this create the words
        System.out.println(this.wordsOut);
        System.out.println(this.level.getNumberOfWords());
        if(this.wordsOut < this.level.getNumberOfWords()) {
            // Get the words
            this.wordsOut = this.wordsOut + 1;

            String []wordsAux = this.level.getWords();

            this.words.add(new Word(wordsAux[MathUtils.random(0, this.words.size())], this.world));

            if(MathUtils.randomBoolean(.1f)) {
                this.powers.add(new Powers(MathUtils.random(Powers.FROZEN, Powers.RANDOM), this.world, this.words, this.timer));
            }
        }
    }

}
