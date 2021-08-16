package com.mygdx.maniac.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Levels {

    // This class manage the levels

    public final static int LEVEL_0 = 0;
    public final static int LEVEL_1 = 1;
    public final static int LEVEL_2 = 2;

    private int actualLevel;
    private JsonReader json;
    private JsonValue base, component;


    public Levels(int level){
        this.actualLevel = level;

        // Set the JSON to get the words
        this.json = new JsonReader();

        // Get the json
        this.base = this.json.parse(Gdx.files.internal("EnglishWordsOrder.json"));
    }

    public String []getWords() {
        // Return a word deending on the level
        if(this.actualLevel == LEVEL_0) {
            String palabras[] = new String[20];

            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = this.base.get("lessThanOrEqualsTo4").getString((int)(Math.random() * this.base.get("lessThanOrEqualsTo4").size) );
            }
            System.out.println(palabras);
            return palabras;
        }
        return new String[0];
    }

}
