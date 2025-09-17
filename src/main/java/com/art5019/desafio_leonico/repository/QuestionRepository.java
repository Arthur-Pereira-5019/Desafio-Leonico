package com.art5019.desafio_leonico.repository;

import com.art5019.desafio_leonico.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
