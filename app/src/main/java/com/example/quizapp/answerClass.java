package com.example.quizapp;

public class answerClass {
    private int optionA,optionB,optionC,optionD,questionId,answerId;

    public answerClass(int questionId,int optionA, int optionB, int optionC, int optionD, int answerId) {
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public int getOptionA() {
        return optionA;
    }

    public void setOptionA(int optionA) {
        this.optionA = optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public void setOptionB(int optionB) {
        this.optionB = optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public void setOptionC(int optionC) {
        this.optionC = optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public void setOptionD(int optionD) {
        this.optionD = optionD;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
