package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.maniac.screens.game.Game;

public class Word {

    private Texture texture;
    private String word;
    private BodyDef bodyDef;
    private Body body;
    private World world;
    private PolygonShape shape;

    public Word(String word, World world) {
        // Configurate box2d
        super();

        this.bodyDef = new BodyDef();
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        this.bodyDef.position.set(2, 5);
        this.bodyDef.fixedRotation = true;

        this.world = world;
        this.body = this.world.createBody(this.bodyDef);

        this.shape = new PolygonShape();
        this.shape.setAsBox(.5f, .1f);

        this.body.createFixture(this.shape, 1.0f);
        this.shape.dispose();

        this.word = word;

    }

    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public void drawText(BitmapFont font, Batch batch) {
        // Draw the word in the batch
        //this.shape
        font.draw(batch, this.word,this.body.getPosition().x * 100.f, this.body.getPosition().y * 100.f);

    }

    public String getWord() {
        return word;
    }
}
