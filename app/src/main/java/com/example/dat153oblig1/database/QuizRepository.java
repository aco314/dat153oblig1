package com.example.dat153oblig1.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dat153oblig1.QuizCard;

import java.util.List;

public class QuizRepository {

    private QuizDAO quizDAO;
    private LiveData<List<QuizCard>> allQuizCards;

    QuizRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        quizDAO = db.quizDAO();
        allQuizCards = quizDAO.getQuizCards();
    }

    LiveData<List<QuizCard>> getAllQuizCards() {
        return allQuizCards;
    }

    void insert(QuizCard quizCard) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            quizDAO.insert(quizCard);
        });
    }

    void delete(QuizCard quizCard) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            quizDAO.delete(quizCard);
        });
    }
}
