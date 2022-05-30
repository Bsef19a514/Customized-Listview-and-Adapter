package com.example.customizedadapter;

public class Question {
    private String question;
    private String correctOption;
    private String[] options;

    public Question(String question, String correctOption, String[] options) {
        this.question = question;
        this.correctOption = correctOption;
        this.options = options;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public String[] getOptions() {
        return options;
    }
}
