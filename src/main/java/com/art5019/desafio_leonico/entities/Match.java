package com.art5019.desafio_leonico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Match {

    @Id
    Integer id;

    @OneToMany(mappedBy = "currentMatch")
    List<LoggedPlayer> players = new ArrayList<>();


}
