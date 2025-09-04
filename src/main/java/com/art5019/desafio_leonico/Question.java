package com.art5019.desafio_leonico;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Question implements Serializable {
    String statement;
    int basePoints;
    int dificulty;
    int extraTime;
    String answer;


}
