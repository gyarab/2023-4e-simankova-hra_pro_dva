package com.example.musiuzfungovat;

import java.util.Random;

public class Question {
    private int number1, number2, answer, answerPosition;
    private int [] answerArray;
    private int upperLimit; //jake bude max number1 nebo number2
    private String questionPhrase;


    //generuje nove random otazky
    public Question(int UpperLimit){
        this.upperLimit = UpperLimit;
        Random randomNumber = new Random();


        this.number1 = randomNumber.nextInt(UpperLimit);
        this.number2 = randomNumber.nextInt(UpperLimit);
        this.answer = this.number1 + this.number2;
        this.questionPhrase = number1 + "+" + number2 + "=";
        this.answerPosition = randomNumber.nextInt(4);

        this.answerArray = new int[]{0,1,2,3};
        this.answerArray[0]= answer + 3;
        this.answerArray[1] = answer + 16;
        this.answerArray[2] = answer - 8;
        this.answerArray[3] = answer  - 1;
        this.answerArray = promichani(this.answerArray);

        answerArray[answerPosition] = answer;
    }

    //zamicha pozice odpovedi (buttons) tak aby spravna odpoved nebyla porad na stejnem miste
    private int [] promichani(int[] array){
        int index, temp;
        Random randomNumberGen = new Random();
        for(int i = array.length-1; i>0; i--){
            index = randomNumberGen.nextInt(i+1);
            temp = array[index];
            array[index] = array [i];
            array[i] = temp;
        }
        return array;
    }



    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperList() {
        return upperLimit;
    }

    public void setUpperList(int upperList) {
        this.upperLimit = upperList;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;

    }
}
