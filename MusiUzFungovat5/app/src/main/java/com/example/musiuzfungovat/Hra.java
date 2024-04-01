package com.example.musiuzfungovat;

import java.util.ArrayList;
import java.util.List;

public class Hra {
    private List<Question> questions;
    private int numberRight, numberWrong, totalQuestions, skore;
    private Question otazka; //curent question

    public Hra() {
        numberRight = 0;
        numberWrong = 0;
        totalQuestions = 0;
        skore = 0;
        otazka = new Question(60);
        questions = new ArrayList<Question>();

    }

    //vytvareni novych otazek
    public void vytvorNovouOtazku() {
        otazka = new Question(totalQuestions * 2 + 5);
        totalQuestions++;
        questions.add(otazka);
    }

    public boolean checkingAnswers(int prijateAnswers) {
        boolean isRight;
        if (otazka.getAnswer() == prijateAnswers) {
            numberRight++;
            isRight = true;
        } else {
            numberWrong++;
            isRight = false;
        }
        skore = numberRight *10-numberWrong*30;
        return isRight;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberRight() {
        return numberRight;
    }

    public void setNumberRight(int numberRight) {
        this.numberRight = numberRight;
    }

    public int getSkore() {
        return skore;
    }

    public void setSkore(int skore) {
        this.skore = skore;
    }


    public int getNumberWrong() {
        return numberWrong;
    }

    public void setNumberWrong(int numberWrong) {
        this.numberWrong = numberWrong;
    }

    public Question getOtazka() {
        return otazka;
    }

    public void setOtazka(Question otazka) {
        this.otazka = otazka;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

}
