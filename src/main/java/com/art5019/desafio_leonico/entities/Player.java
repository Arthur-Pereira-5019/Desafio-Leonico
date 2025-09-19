package com.art5019.desafio_leonico.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "player")
public class Player {

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    @Column
    int points;

    @Column
    Date startedLastQuestion;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    int currentQuestion;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "match_id")
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
