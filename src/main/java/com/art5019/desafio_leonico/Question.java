package com.art5019.desafio_leonico;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Question implements Serializable {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String statement;

    @Column()
    int basePoints;

    @Column()
    int dificulty;
    @Column()
    int extraTime;
    @Column()
    String answer;
    @Column()
    QuestionType type;





}
