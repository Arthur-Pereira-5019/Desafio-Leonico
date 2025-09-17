package com.art5019.desafio_leonico.services;

import com.art5019.desafio_leonico.entities.Match;
import com.art5019.desafio_leonico.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServices {

    @Autowired
    QuestionServices qs;

    @Autowired
    MatchRepository mr;

    public void deleteMatch(Integer id) {
        mr.delete(findById(id));
    }

    public Match findById(Integer id) {
        return mr.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
    }

}
