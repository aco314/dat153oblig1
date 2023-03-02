package com.example.dat153oblig1;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;

import com.example.dat153oblig1.database.QuizViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UITest {

    //@Rule public ActivityScenarioRule<QuizActivity> activityScenarioRule = new ActivityScenarioRule<>(QuizActivity.class);

    @Test
    public void playButtonOpensQuizActivity() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.playBtn)).perform(click());
        onView(withId(R.id.quizActivityLayout)).check(matches(isDisplayed()));

    }

    @Test
    public void scoreUpdatesCorrectly1() {
        ActivityScenario scenario = ActivityScenario.launch(QuizActivity.class);

        scenario.onActivity(activity -> {
            QuizActivity quizActivity = (QuizActivity) activity;
            QuizCard card = quizActivity.getCurrentCard();
            String correctAns = card.getCorrectAns();

            Button button1 = (Button) activity.findViewById(R.id.alt1Button);
            Button button2 = (Button) activity.findViewById(R.id.alt2Button);
            Button button3 = (Button) activity.findViewById(R.id.alt3Button);

            if (button1.getText().equals(correctAns)) {
                button1.performClick();
            } else if (button2.getText().equals(correctAns)) {
                button2.performClick();
            } else {
                button3.performClick();
            }
        });

        onView(withId(R.id.correctCounterTextView)).check(matches(withText("1 out of 1 correct")));
        //onView(withId(R.id.playAgainButton)).perform(click());
    }

    @Test
    public void scoreUpdatesCorrectly2() {
        ActivityScenario scenario = ActivityScenario.launch(QuizActivity.class);

        scenario.onActivity(activity -> {
            QuizActivity quizActivity = (QuizActivity) activity;
            QuizCard card = quizActivity.getCurrentCard();
            String correctAns = card.getCorrectAns();

            Button button1 = (Button) activity.findViewById(R.id.alt1Button);
            Button button2 = (Button) activity.findViewById(R.id.alt2Button);

            if (button1.getText().equals(correctAns)) {
                button2.performClick();
            } else {
                button1.performClick();
            }
        });

        onView(withId(R.id.correctCounterTextView)).check(matches(withText("1 out of 2 correct")));
    }


    @Test
    public void addNewCardUpdatesDatabase() {
        ActivityScenario scenario = ActivityScenario.launch(DatabaseActivity.class);
        scenario.onActivity(activity -> {
            DatabaseActivity databaseActivity = (DatabaseActivity) activity;

            List<Integer> sizes = new ArrayList<Integer>();

            databaseActivity.quizViewModel.getAllQuizCards().observe(databaseActivity, viewModelCards -> {
                sizes.add(viewModelCards.size());

                if (sizes.size() > 1) {
                    assertEquals(sizes.get(0).longValue() + 1, sizes.get(sizes.size()-1).longValue());
                }
            });

            QuizCard newCard = new QuizCard(Uri.parse("android.resource://com.example.dat153oblig1/drawable/axe"), "1", "2", "3");
            databaseActivity.onDialogPositiveClick(newCard);
        });

    }

}