package com.art5019.desafio_leonico.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "player")
public class Player {

    @Column
    int points;

    @Column
    Date startedLastQuestion;

    @Column
    Integer id;

    @Column
    int currentQuestion;

    @ManyToOne
    @JoinColumn(name = "id")
    Match currentMatch;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getStartedLastQuestion() {
        return startedLastQuestion;
    }

    public void setStartedLastQuestion(Date startedLastQuestion) {
        this.startedLastQuestion = startedLastQuestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public Match getCurrentMatch() {
        return currentMatch;
    }

    public void setCurrentMatch(Match currentMatch) {
        this.currentMatch = currentMatch;
    }
}
