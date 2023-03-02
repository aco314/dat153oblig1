package com.example.dat153oblig1.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.dat153oblig1.QuizCard;

import java.util.List;

public class QuizViewModel extends AndroidViewModel {

    private QuizRepository repository;
    private final LiveData<List<QuizCard>> allQuizCards;

    public QuizViewModel(Application application) {
        super(application);
        this.repository = new QuizRepository(application);
        this.allQuizCards = repository.getAllQuizCards();
    }

    public LiveData<List<QuizCard>> getAllQuizCards() {
        return this.allQuizCards;
    }

    public void insert(QuizCard quizCard) {
        this.repository.insert(quizCard);
    }

    public void delete(QuizCard quizCard) {
        this.repository.delete(quizCard);
    }
}
