package com.art5019.desafio_leonico.repository;

import com.art5019.desafio_leonico.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
