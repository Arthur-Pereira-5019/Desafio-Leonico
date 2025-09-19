package com.art5019.desafio_leonico.services;

import com.art5019.desafio_leonico.entities.JoinMatchRequest;
import com.art5019.desafio_leonico.entities.Match;
import com.art5019.desafio_leonico.entities.Player;
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

    public void joinMatch (JoinMatchRequest jmr) {
        Match m = findById(jmr.id());
        if(jmr.password().equals(m.getPassword())) {
            Player p = new Player(jmr.playerName());
            ps.savePlayer(p);
            m.getPlayers().add(p);
        }
    }

}
