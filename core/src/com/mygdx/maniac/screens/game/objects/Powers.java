package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Powers implements ActionListener {

    public final static int FROZEN = 0;
    public final static int SLOW = 1;
    public final static int BLOW = 2;

    private int power;
    private String powerName;
    private ArrayList<Word> words;
    private Timer timerGame, timerPower;

    private Texture texture;
    private BodyDef bodyDef;
    private Body body;
    private World world;
    private PolygonShape shape;


    public Powers(int power, World world, ArrayList<Word> words, Timer timerGame) {
        // This class manage the powers

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

        // Create the body
        this.bodyDef = new BodyDef();
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        this.bodyDef.position.set(Screen.WORD_WIDTH - 1.f, Screen.WORD_HEIGHT);
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
        if(this.power == FROZEN) {
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
            this.world.setGravity(new Vector2(0, Game.DEFAULT_GRAVITY * -1));
            this.timerPower.start();
        }
    }

    public void drawText(BitmapFont font, Batch batch) {
        // Draw the word in the batch
        //this.shape
        font.draw(batch, this.powerName,this.body.getPosition().x * 100.f, this.body.getPosition().y * 100.f);
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
