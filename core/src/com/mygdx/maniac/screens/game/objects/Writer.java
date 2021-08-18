package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.assets.Assets;

import javax.tools.FileObject;

public class Writer{

    /* THIs class is  in charge of get the words that the user write*/
    private String word;
    private Sprite background;
    private BitmapFont font;
    private Sound soundKeyPress;

    private final int SIZEX = 200;
    private final int SIZEY = 200;

    public Writer() {
        this.word = "";
        this.background = Assets.getSprite(Assets.MAQUINA_ESCRIBIR_HOJA);
        this.background.setPosition(0, 0);
        this.background.setSize(this.SIZEX, SIZEY);

        this.soundKeyPress = Assets.getSound(Assets.KEY_PRESS);

        this.font = new BitmapFont();
    }

    public void update() {
        // this method get the key press and write the word

        for(int i = Input.Keys.A; i <= Input.Keys.Z; i++ ) {
            if(Gdx.input.isKeyJustPressed(i) && this.word.length() <= 6){
                this.soundKeyPress.play();
                word += Input.Keys.toString(i);
            }
        }

        // Delete text
        if(Gdx.input.isKeyPressed(Input.Keys.DEL) == true && this.word.length() > 0) {
            this.soundKeyPress.play();
            this.word = this.word.substring(0, this.word.length() - 1);
        }
    }

    public void drawText(Batch batch) {
        // This method draw in the screen the word

        background.draw(batch);
        this.font.setColor(Color.BLACK);
        this.font.draw(batch, this.word, SIZEX / 3.f, SIZEY-30);
    }

    public void cleanWord() {
        // This method clean the word
        this.word = "";
    }

    public String getWord() {
        return word;
    }

    public int getSIZEX() {
        return SIZEX;
    }

    public int getSIZEY() {
        return SIZEY;
    }
}
