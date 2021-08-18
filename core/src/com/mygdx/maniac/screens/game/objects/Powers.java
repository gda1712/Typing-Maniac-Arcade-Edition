package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.Game;
import com.mygdx.maniac.screens.game.assets.Assets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Powers implements ActionListener {

    public final static int FROZEN = 0;
    public final static int SLOW = 1;
    public final static int BLOW = 2;
    public final static int RANDOM = 3;

    private int power;
    private String powerName;
    private ArrayList<Word> words;
    private Timer timerGame, timerPower;

    private Sprite sprite;
    private BodyDef bodyDef;
    private Body body;
    private World world;
    private PolygonShape shape;

    private Sound powerSound;


    public Powers(int power, World world, ArrayList<Word> words, Timer timerGame) {
        // This class manage the powers

        this.sprite = Assets.getSprite(Assets.BARRA_TEXTO_DORADA);
        this.sprite.setSize(100, 20);

        this.power = power;
        this.words = words;
        this.timerGame = timerGame;
        this.timerPower = new Timer(5000, this);

        if(this.power == FROZEN)
            this.powerName = "FROZEN";
        else if(this.power == SLOW)
            this.powerName = "SLOW";
        else if(this.power == BLOW)
            this.powerName = "BLOW";
        else if(this.power == RANDOM)
            this.powerName = "RANDOM";

        // Create the body
        this.bodyDef = new BodyDef();
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        this.bodyDef.position.set(Screen.WORD_WIDTH - 1f, Screen.WORD_HEIGHT);
        this.bodyDef.fixedRotation = true;

        this.world = world;
        this.body = this.world.createBody(this.bodyDef);

        this.shape = new PolygonShape();
        this.shape.setAsBox(.5f, .1f);

        this.body.createFixture(this.shape, 1.0f);
        this.shape.dispose();
    }

    public void activate() {
        // Activate hte power
        //Timer
        if(this.power == RANDOM){
            this.power = MathUtils.random(0, 2);
            if(this.power == FROZEN)
                this.powerName = "FROZEN";
            else if(this.power == SLOW)
                this.powerName = "SLOW";
            else if(this.power == BLOW)
                this.powerName = "BLOW";
        }

        if(this.power == FROZEN) {
            // Sound
            this.powerSound = Assets.getSound(Assets.FREEZE);
            this.powerSound.play();

            this.world.setGravity(new Vector2(0, 0));

            for(int i = 0; i < this.words.size(); i++) {
                this.words.get(i).getBody().setLinearVelocity(0, 0);
            }

            this.timerPower.start();
            this.timerGame.stop();
        }
        else if(this.power == SLOW) {
            this.world.setGravity(new Vector2(0, 0));
            this.timerPower.start();
            this.timerGame.stop();
        }
        else if(this.power == BLOW) {
            this.powerSound = Assets.getSound(Assets.BLOW);
            this.powerSound.play();

            this.world.setGravity(new Vector2(0, Game.DEFAULT_GRAVITY * -.5f));
            this.timerPower.start();
        }
    }

    public void drawText(BitmapFont font, Batch batch) {
        // Draw the word in the batch
        this.sprite.setPosition((this.body.getPosition().x * 100.f) - 50, (this.body.getPosition().y * 100.f) - 10);
        this.sprite.draw(batch);
        font.draw(batch, this.powerName,(this.body.getPosition().x * 100.f) - 20, (this.body.getPosition().y * 100.f) + 5);
    }

    public String getPowerName() {
        return powerName;
    }

    public Body getBody() {
        return body;
    }

    //------------------------------TIMER------------------------
    @Override
    public void actionPerformed(ActionEvent e) {

        // Reboot the gravity game
        if(this.power == FROZEN){
            this.timerGame.start();
            this.timerPower.stop();
            this.world.setGravity(new Vector2(0, Game.DEFAULT_GRAVITY));
        }
        else if(this.power == SLOW){
            this.timerGame.start();
            this.timerPower.stop();
            this.world.setGravity(new Vector2(0, Game.DEFAULT_GRAVITY));
        }
        else if(this.power == BLOW) {
            this.timerPower.stop();
            this.world.setGravity(new Vector2(0, Game.DEFAULT_GRAVITY));
        }
    }
}
