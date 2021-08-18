package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.Game;
import com.mygdx.maniac.screens.game.assets.Assets;

public class Word {

    private Sprite sprite;
    private String word;
    private BodyDef bodyDef;
    private Body body;
    private World world;
    private PolygonShape shape;

    public Word(String word, World world) {
        // Configurate box2d

        this.sprite = Assets.getSprite(Assets.HOJA_TEXTO_PERGAMINO);
        this.sprite.setSize(100, 30);

        this.bodyDef = new BodyDef();
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        this.bodyDef.position.set(MathUtils.random(2.f, Screen.WORD_WIDTH - 2.f), Screen.WORD_HEIGHT);
        this.bodyDef.fixedRotation = true;

        this.world = world;
        this.body = this.world.createBody(this.bodyDef);

        this.shape = new PolygonShape();
        this.shape.setAsBox(.5f, .1f);

        this.body.createFixture(this.shape, 1.0f);
        this.shape.dispose();


        this.word = word;

    }

    public void drawText(BitmapFont font, Batch batch) {
        // Draw the word in the batch
        this.sprite.setPosition((this.body.getPosition().x * 100.f) - 50, (this.body.getPosition().y * 100.f) - 20);
        this.sprite.draw(batch);
        font.setColor(Color.FIREBRICK);
        font.draw(batch, this.word,(this.body.getPosition().x * 100.f) - 12, (this.body.getPosition().y * 100.f) + 5);

    }

    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public String getWord() {
        return word;
    }

    public Body getBody() {
        return body;
    }
}
