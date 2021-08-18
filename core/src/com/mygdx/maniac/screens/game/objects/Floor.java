package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.Game;

public class Floor {

    public final static int WORDS_FLOOR = 0;
    public final static int POWERS_FLOOR = 1;

    private BodyDef bodyDef;
    private Body body;
    private World world;
    private PolygonShape shape;

    public Floor(int type, World world) {
        // Init the floor
        this.bodyDef = new BodyDef();
        this.bodyDef.type = BodyDef.BodyType.StaticBody;

        this.shape = new PolygonShape();

        // Set the position
        if(type == WORDS_FLOOR) {
            this.bodyDef.position.set(0, 0);
            this.shape.setAsBox(Game.WORD_WIDTH, .1f);
        }
        else if(type == POWERS_FLOOR) {
            this.bodyDef.position.set(Game.WORD_WIDTH - .5f, 2.f);
            this.shape.setAsBox(.5f, .1f);
        }

        this.bodyDef.fixedRotation = true;
        this.world = world;
        this.body = this.world.createBody(this.bodyDef);

        this.body.createFixture(this.shape, 1.0f);
        this.shape.dispose();
    }

    public Body getBody() {
        return body;
    }
}
