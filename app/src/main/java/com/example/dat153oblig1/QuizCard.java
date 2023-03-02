package com.example.dat153oblig1;

import android.net.Uri;
import android.util.Log;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "quizcards")
public class QuizCard {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String imageLinkString;
    private String correctAns;
    private String wrongAns1;
    private String wrongAns2;

    //@Ignore
    //private Uri imageLinkUri;
    //@Ignore
    //private String[] answers;

    public QuizCard() {}

    public QuizCard(Uri imageLink, String correctAns, String wrongAns1, String wrongAns2) {
        //this.imageLinkUri = imageLink;
        this.imageLinkString = imageLink.toString();
        //this.answers = new String[]{correctAns, wrongAns1, wrongAns2};
        this.correctAns = correctAns;
        this.wrongAns1 = wrongAns1;
        this.wrongAns2 = wrongAns2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageLinkString(String imageLinkString) {
        this.imageLinkString = imageLinkString;
        //this.imageLinkUri = Uri.parse(imageLinkString);
    }

    public String getImageLinkString() {
        return imageLinkString;
    }

    public Uri getImageLinkUri() {
        //return imageLinkUri;
        return Uri.parse(imageLinkString);
    }

    /*public void setImageLinkUri(Uri imageLinkUri) {
        this.imageLinkUri = imageLinkUri;
        //this.imageLinkString = imageLinkUri.toString();
    }*/

    public String[] getAnswers() {
        //return answers;
        return new String[]{correctAns, wrongAns1, wrongAns2};
    }

    public String getCorrectAns() {
        //return answers[0];
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getWrongAns1() {
        //return answers[1];
        return wrongAns1;
    }

    public void setWrongAns1(String wrongAns1) {
        this.wrongAns1 = wrongAns1;
    }

    public String getWrongAns2() {
        //return answers[2];
        return wrongAns2;
    }

    public void setWrongAns2(String wrongAns2) {
        this.wrongAns2 = wrongAns2;
    }

    public static QuizCard[] exampleData() {
        Log.i("aaa", "first....");
        Uri uri1 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/axe");
        Uri uri2 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/lemon");
        Uri uri3 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/dog");
        Uri uri4 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/banana");
        Uri uri5 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/applelogo");

        return new QuizCard[] {
                new QuizCard(uri1, "Axe", "Shovel", "Hammer"),
                new QuizCard(uri2, "Lemon", "Grapefruit", "Citrus"),
                new QuizCard(uri3, "Dog", "Wolf", "Cat"),
                new QuizCard(uri4, "Banana", "Strawberry", "Lemon"),
                new QuizCard(uri5, "Apple", "Samsung", "LG")
        };
    }

}
