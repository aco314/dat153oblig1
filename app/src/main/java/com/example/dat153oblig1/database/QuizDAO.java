package com.example.dat153oblig1.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dat153oblig1.QuizCard;

import java.util.List;

@Dao
public interface QuizDAO {

    @Query("SELECT * FROM quizcards")
    LiveData<List<QuizCard>> getQuizCards();
/*
    @Query("SELECT * FROM quizcards ORDER BY RANDOM() LIMIT 1")
    QuizCard getRandomCard();
*/
    @Insert
    void insert(QuizCard quizCard);

    @Insert
    void insertAll(QuizCard... quizCards);

    @Delete
    void delete(QuizCard quizCard);
}
