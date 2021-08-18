package com.mygdx.maniac.screens.game.information;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

public class Levels {

    // This class manage the levels

    public final static int LEVEL_0 = 0;
    public final static int LEVEL_1 = 1;
    public final static int LEVEL_2 = 2;
    public final static int ARCADE = 3;

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

        if(this.actualLevel == LEVEL_0) {
            this.departureTime = 1200;
            this.numberOfWords = 20;
        }
        else if(this.actualLevel == LEVEL_1) {
            this.departureTime = 1000;
            this.numberOfWords = 30;
        }
        else if(this.actualLevel == LEVEL_2) {
            this.departureTime = 800;
            this.numberOfWords = 40;
        }
        else if(this.actualLevel == ARCADE) {
            this.departureTime = 1200;
            this.numberOfWords = 1000;
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
            String palabras[] = new String[numberOfWords];

            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = this.base.get("lessThanOrEqualsTo4").getString((int)(Math.random() * this.base.get("lessThanOrEqualsTo4").size) );

            }
            System.out.println(palabras);
            return palabras;
        }

        if(this.actualLevel == LEVEL_1) {
            String palabras[] = new String[numberOfWords];

            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = this.base.get("equalsTo5").getString((int)(Math.random() * this.base.get("equalsTo5").size) );

            }
            System.out.println("Desde lv2");
            return palabras;
        }

        if(this.actualLevel == LEVEL_2) {
            String palabras[] = new String[numberOfWords];

            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = this.base.get("equalsTo6").getString((int)(Math.random() * this.base.get("equalsTo6").size) );

            }
            System.out.println(palabras);
            return palabras;
        }
        if(this.actualLevel == ARCADE) {
            String palabras[] = new String[this.numberOfWords];

            this.base = this.json.parse(Gdx.files.internal("EnglishWords.json"));

            for (int i = 0; i < palabras.length; i++) {


                palabras[i] = this.base.get("EnglishWords").getString((int)(Math.random() * this.base.get("EnglishWords").size) );

            }
            System.out.println(palabras);
            return palabras;
        }
        return new String[0];
    }

    public int getActualLevel() {
        return actualLevel;
    }
}
