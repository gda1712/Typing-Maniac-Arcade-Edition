package com.mygdx.maniac.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Levels {

    // This class manage the levels

    public final static int LEVEL_0 = 0;
    public final static int LEVEL_1 = 1;
    public final static int LEVEL_2 = 2;

    private int departureTime;

    private int actualLevel;
    private int numberOfWords;
    private JsonReader json;
    private JsonValue base;

    public Levels(int level){
        this.actualLevel = level;

        // Set the JSON to get the words
        this.json = new JsonReader();

        // Get the json
        this.base = this.json.parse(Gdx.files.internal("EnglishWordsOrder.json"));

        this.base.get("lessThanOrEqualsTo4");

        if(this.actualLevel == LEVEL_0) {
            this.departureTime = 1200;
            this.numberOfWords = 20;
        }
        else if(this.actualLevel == LEVEL_1) {
            this.departureTime = 1000;
            this.numberOfWords = 30;
        }
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getNumberOfWords() {
        return numberOfWords;
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
