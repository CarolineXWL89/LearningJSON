package com.example.caroline.learningjson;

/**
 * Created by princ on 12/01/2018.
 */

public class WordObject {
    private String word;
    private int score;
    private int numSyllables;

    public WordObject(){
        word = "default";
        score = 0;
        numSyllables = 2;
    }

    public String getWord() {
        return word;
    }

    public int getScore() {
        return score;
    }

    public int getNumSyllables() {
        return numSyllables;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNumSyllables(int numSyllables) {
        this.numSyllables = numSyllables;
    }
}
