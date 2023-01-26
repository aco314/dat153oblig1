package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView correctCounterTextView;
    ImageView quizImageView;
    TextView timerTextView;
    Button alt1Button, alt2Button, alt3Button;

    TextView correctWrongTextView;
    Button quizBackButton;
    Button playAgainButton;

    ApplicationData appData;
    boolean hardMode;
    CountDownTimer timer;
    QuizCard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        correctCounterTextView = (TextView) findViewById(R.id.correctCounterTextView);
        quizImageView = (ImageView) findViewById(R.id.quizImageView);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        alt1Button = (Button) findViewById(R.id.alt1Button);
        alt2Button = (Button) findViewById(R.id.alt2Button);
        alt3Button = (Button) findViewById(R.id.alt3Button);

        correctWrongTextView = (TextView) findViewById(R.id.correctWrongTextView);
        quizBackButton = (Button) findViewById(R.id.quizBackButton);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);

        appData = ((ApplicationData) getApplicationContext());
        hardMode = getIntent().getBooleanExtra("hardMode", false);
        if (hardMode) {
            startTimer();
        }

        card = appData.getRandomCard();
        if (card.getImageLinkUri() == null) {
            quizImageView.setImageResource(card.getImageLinkInt());
        } else {
            quizImageView.setImageURI(card.getImageLinkUri());
        }
        String counterText = appData.getGamesWon() + " out of " + appData.getGamesPlayed() + " correct";
        correctCounterTextView.setText(counterText);

        // Shuffle card alternatives
        String[] alternatives = card.getAnswers().clone();
        List<String> altsList = Arrays.asList(alternatives);
        Collections.shuffle(altsList);
        altsList.toArray(alternatives);

        alt1Button.setText(alternatives[0]);
        alt2Button.setText(alternatives[1]);
        alt3Button.setText(alternatives[2]);
    }

    // "Back" button pressed (after round ended)
    public void backToMain(View view) {
        finish();
    }

    // "Play again" button pressed (after round ended)
    public void playAgain(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("hardMode", hardMode);
        startActivity(intent);
        finish();
    }

    // One of three alternatives pressed
    public void selectAlternative(View view) {
        Button buttonPressed = (Button) view;
        String alternativeSelected = buttonPressed.getText().toString();

        // If correct alternative pressed
        if (alternativeSelected == card.getCorrectAns()) {
            correctWrongTextView.setText("Correct!");
            correctWrongTextView.setTextColor(Color.rgb(27, 145, 32));
            buttonPressed.setBackgroundColor(Color.rgb(27, 145, 32));  // green
            appData.gameWon();
        } else {
            //correctWrongTextView.setText("Wrong!");
            //correctWrongTextView.setTextColor(Color.rgb(216 , 16, 16));
            buttonPressed.setBackgroundColor(Color.rgb(216 , 16, 16));  // red
            makeCorrectGreen();
            appData.gameLost();
        }

        changeViewVisibilities();
    }

    // Function to find the correct alternative button and make it green
    private void makeCorrectGreen() {
        if (alt1Button.getText() == card.getCorrectAns()) {
            alt1Button.setBackgroundColor(Color.rgb(27, 145, 32));
        } else if (alt2Button.getText() == card.getCorrectAns()) {
            alt2Button.setBackgroundColor(Color.rgb(27, 145, 32));
        } else if (alt3Button.getText() == card.getCorrectAns()) {
            alt3Button.setBackgroundColor(Color.rgb(27, 145, 32));
        }
    }

    // Function that's called at end of round, to enable and disable the right View's.
    private void changeViewVisibilities() {
        alt1Button.setClickable(false);
        alt2Button.setClickable(false);
        alt3Button.setClickable(false);
        quizImageView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        correctWrongTextView.setVisibility(View.VISIBLE);
        quizBackButton.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);

        String counterText = appData.getGamesWon() + " out of " + appData.getGamesPlayed() + " correct";
        correctCounterTextView.setText(counterText);
    }

    // Start 30 second countdown-timer if hard mode is enabled
    void startTimer() {
        timer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(millisUntilFinished / 1000 + " seconds left");
            }
            public void onFinish() {
                appData.gameLost();
                makeCorrectGreen();
                changeViewVisibilities();
            }
        };
        timer.start();
    }

    void cancelTimer() {
        if (timer != null)
            timer.cancel();
    }

    // Need to cancel timer every time the Activity is exited, because otherwise
    // the timer keeps running in the background. It will lead to a memory leak.
    @Override
    protected void onStop() {
        super.onStop();
        cancelTimer();
    }
}