package com.art5019.desafio_leonico.entities;

public class QuestionDTO {
    String questionText;
    QuestionType type;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }
}
