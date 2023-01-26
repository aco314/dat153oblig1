package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AddCardDialogFragment.AddCardDialogListener {

    Switch hardSwitch;

    ApplicationData appData;
    static boolean firstLaunch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hardSwitch = (Switch) findViewById(R.id.hardSwitch);

        appData = ((ApplicationData) getApplicationContext());

        // Only create the question cards the first time MainActivity is opened
        if (!firstLaunch) {
            addExampleData();
            firstLaunch = true;
        }
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
        appData.addCard(newCard);
        Snackbar.make(findViewById(R.id.mainRootLayout), "Item Added!", Snackbar.LENGTH_LONG).show();
    }

    public void addExampleData() {
        QuizCard c1 = new QuizCard(R.drawable.axe, "Axe", "Shovel", "Hammer");
        QuizCard c2 = new QuizCard(R.drawable.lemon, "Lemon", "Grapefruit", "Citrus");
        QuizCard c3 = new QuizCard(R.drawable.dog, "Dog", "Wolf", "Cat");
        QuizCard c4 = new QuizCard(R.drawable.banana, "Banana", "Strawberry", "Lemon");
        QuizCard c5 = new QuizCard(R.drawable.applelogo, "Apple", "Samsung", "LG");
        appData.addCard(c1);
        appData.addCard(c2);
        appData.addCard(c3);
        appData.addCard(c4);
        appData.addCard(c5);
    }
}