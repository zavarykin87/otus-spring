package com.zavarykin.task3.domain;

import java.util.Objects;

public class Question {

    private final int number;
    private final String text;
    private final String option1;
    private final String option2;
    private final String option3;
    private final String option4;
    private final String rightAnswer;

    public Question(int number, String text, String option1, String option2, String option3, String option4, String rightAnswer) {
        this.number = number;
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Question question = (Question) object;
        return number == question.number
                && Objects.equals(text, question.text)
                && Objects.equals(option1, question.option1)
                && Objects.equals(option2, question.option2)
                && Objects.equals(option3, question.option3)
                && Objects.equals(option4, question.option4)
                && Objects.equals(rightAnswer, question.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, text, option1, option2, option3, option4, rightAnswer);
    }

}
