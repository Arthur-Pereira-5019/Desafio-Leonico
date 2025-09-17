package com.art5019.desafio_leonico.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "player")
public class LoggedPlayer {

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


}
