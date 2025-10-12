package com.art5019.desafio_leonico.services;

import com.art5019.desafio_leonico.entities.*;
import com.art5019.desafio_leonico.entities.dtos.CreateMatchRequest;
import com.art5019.desafio_leonico.entities.dtos.JoinMatchRequest;
import com.art5019.desafio_leonico.entities.dtos.JoinMatchReturn;
import com.art5019.desafio_leonico.exceptions.MatchEnteringException;
import com.art5019.desafio_leonico.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServices {

    @Autowired
    QuestionServices qs;

    @Autowired
    MatchRepository mr;

    @Autowired
    PlayerServices ps;

    public void deleteMatch(Integer id) {
        mr.delete(findById(id));
    }

    public Match findById(Integer id) {
        return mr.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public JoinMatchReturn joinMatch (JoinMatchRequest jmr) {
        Match m = findById(jmr.id());
        if(jmr.password().equals(m.getPassword())) {
            Player p = new Player(jmr.playerName());
            ps.savePlayer(p);
            m.getPlayers().add(p);
            JoinMatchReturn jmret = new JoinMatchReturn(jmr.id(),p.getId());
            return jmret;
        } else {
            throw new MatchEnteringException("Erro ao entrar na partida.");
        }
    }

    public Match createMatch(CreateMatchRequest cmr) {
        Match m = new Match();
        m.setPassword(cmr.password());
        return mr.save(m);
    }

    public QuestionDTO currentQuestion(Integer id) {
        Player p = ps.findPlayer(id);
        return qs.presentQuestion(p.getCurrentMatch().getQuestions().get(p.getCurrentQuestion()));
    }

}
