package com.example.dat153oblig1;

import android.net.Uri;

public class QuizCard {

    private int imageLinkInt;
    private Uri imageLinkUri;
    private String[] answers;

    // Images added from "drawable" folder are of type "int"
    public QuizCard(int imageLink, String correctAns, String wrongAns1, String wrongAns2) {
        this.imageLinkInt = imageLink;
        this.answers = new String[]{correctAns, wrongAns1, wrongAns2};
    }

    // Images manually added by a user in the app have a "Uri" instead
    public QuizCard(Uri imageLink, String correctAns, String wrongAns1, String wrongAns2) {
        this.imageLinkUri = imageLink;
        this.answers = new String[]{correctAns, wrongAns1, wrongAns2};
    }

    public int getImageLinkInt() {
        return imageLinkInt;
    }

    public Uri getImageLinkUri() {
        return imageLinkUri;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getCorrectAns() {
        return answers[0];
    }


    public String getWrongAns1() {
        return answers[1];
    }


    public String getWrongAns2() {
        return answers[2];
    }

}
