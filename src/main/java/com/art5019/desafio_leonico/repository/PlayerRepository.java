package com.art5019.desafio_leonico.repository;

import com.art5019.desafio_leonico.entities.LoggedPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<LoggedPlayer, Integer> {
}
