package com.mygdx.maniac.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.maniac.TypingManiacArcade;
import com.mygdx.maniac.screens.Screen;

public class Game extends Screen {

    public Game(final TypingManiacArcade game) {

        super(game);

    }

    @Override
    public void draw(float delta) {
        this.game.font.draw(this.game.batch, "Hola mundo", 200, 200);
    }

    //-------------------------------------------INPUT METHODS----------------------------

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }
}
