package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.example.dat153oblig1.database.AppDatabase;
import com.example.dat153oblig1.database.QuizDAO;
import com.example.dat153oblig1.database.QuizViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AddCardDialogFragment.AddCardDialogListener {

    Switch hardSwitch;

    private ApplicationData appData;
    private QuizViewModel quizViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hardSwitch = (Switch) findViewById(R.id.hardSwitch);

        appData = ((ApplicationData) getApplicationContext());
        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
    }

    // "Database" button pressed
    public void launchDatabaseView(View view) {
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }

    // "Play" button pressed
    public void launchQuizView(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("hardMode", hardSwitch.isChecked());
        startActivity(intent);
    }

    // "Add Entry" button pressed
    public void launchAddEntryDialog(View view) {
        AddCardDialogFragment dialogFragment = new AddCardDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "dialogA");
    }

    // "Add" button pressed in the "Add new card"-dialog
    @Override
    public void onDialogPositiveClick(QuizCard newCard) {
        quizViewModel.insert(newCard);
        Snackbar.make(findViewById(R.id.mainRootLayout), "Item Added!", Snackbar.LENGTH_LONG).show();
    }

/*    public void addExampleData() {
        //QuizCard c1 = new QuizCard(R.drawable.axe, "Axe", "Shovel", "Hammer");
        Uri uri1 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/axe");
        Uri uri2 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/lemon");
        Uri uri3 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/dog");
        Uri uri4 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/banana");
        Uri uri5 = Uri.parse("android.resource://com.example.dat153oblig1/drawable/applelogo");
        QuizCard c1 = new QuizCard(uri1, "Axe", "Shovel", "Hammer");
        QuizCard c2 = new QuizCard(uri2, "Lemon", "Grapefruit", "Citrus");
        QuizCard c3 = new QuizCard(uri3, "Dog", "Wolf", "Cat");
        QuizCard c4 = new QuizCard(uri4, "Banana", "Strawberry", "Lemon");
        QuizCard c5 = new QuizCard(uri5, "Apple", "Samsung", "LG");
        appData.addCard(c1);
        appData.addCard(c2);
        appData.addCard(c3);
        appData.addCard(c4);
        appData.addCard(c5);
    }*/
}