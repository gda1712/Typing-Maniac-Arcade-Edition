package com.mygdx.maniac.screens.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.maniac.screens.Screen;

public class Writer{

    /* THIs class is  in charge of get the words that the user write*/
    private String word;

    public Writer() {
        this.word = "";
    }

    public void update() {
        // this method get the key press and write the word

        for(int i = Input.Keys.A; i <= Input.Keys.Z; i++ ) {
            if(Gdx.input.isKeyPressed(i)){

                word += Input.Keys.toString(i);
            }
        }

        // Delete text
        if(Gdx.input.isKeyPressed(Input.Keys.DEL) == true && this.word.length() > 0) {
            this.word = this.word.substring(0, this.word.length() - 1);
        }
    }

    public void drawText(BitmapFont font, Batch batch) {
        // This method draw in the screen the word

        font.draw(batch, this.word, Screen.SCREEN_WIDTH / 2.f, 30);
    }

    public void cleanWord() {
        // This method clean the word
        this.word = "";
    }

    public String getWord() {
        return word;
    }


}
