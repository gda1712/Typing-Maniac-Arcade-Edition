package com.mygdx.maniac.screens.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.objects.Word;
import com.mygdx.maniac.screens.game.objects.Writer;
import java.util.ArrayList;

public class Game extends Screen implements ContactListener {

    private World world;
    private Box2DDebugRenderer b2dr;

    private Writer writer;
    private ArrayList <Word> words;

    private Levels level;

    public Game(final TypingManiacArcade game) {

        super(game);

        // Create the world
        this.world = new World(new Vector2(0, -.5f), false);
        this.b2dr = new Box2DDebugRenderer();

        this.writer = new Writer();
        this.level = new Levels(Levels.LEVEL_0);
        this.words = new ArrayList<Word>();

        // Get the words
        String []wordsAux = this.level.getWords();

        // Inicializate the words
        for(int i = 0; i < wordsAux.length; i++) {
            this.words.add(new Word(wordsAux[i], this.world));
        }
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
    public void update() {
        // This method update the logic game
        world.step(1 / 60.f, 6, 2);

        // Comprobate what word is writer
        for(int i = 0; i < this.words.size(); i++) {
            if(this.words.get(i).getWord().compareToIgnoreCase(this.writer.getWord()) == 0) {
                this.words.remove(i);
                this.writer.cleanWord();
            }
        }
    }

    @Override
    public void draw(float delta) {

        // Draw the world

        for(int i = 0; i < this.words.size(); i++) {
            this.words.get(i).drawText(this.game.font, this.game.batch);
        }

        this.writer.drawText(this.game.font, this.game.batch);
        this.game.batch.setProjectionMatrix(cameraBox2d.combined);
        this.b2dr.render(this.world, this.cameraBox2d.combined);

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
}
