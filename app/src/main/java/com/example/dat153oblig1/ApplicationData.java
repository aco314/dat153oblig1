package com.example.dat153oblig1;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationData extends Application {

    private ArrayList<QuizCard> cards = new ArrayList<>();
    private int gamesPlayed = 0;
    private int gamesWon = 0;

    public void addCard(QuizCard card) {
        cards.add(card);
    }

    public ArrayList<QuizCard> getCards() {
        return cards;
    }

    public QuizCard getRandomCard() {
        int index = (int)(Math.random() * cards.size());
        return cards.get(index);
    }

    public void gameWon() {
        this.gamesPlayed++;
        this.gamesWon++;
    }

    public void gameLost() {
        this.gamesPlayed++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
