package com.art5019.desafio_leonico.services;

import com.art5019.desafio_leonico.entities.Player;
import com.art5019.desafio_leonico.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PlayerServices {

    @Autowired
    PlayerRepository pr;

    @Cacheable
    public Player savePlayer(Player player) {
        return pr.save(player);
    }

    public Player updatePonctuation(Integer id, int ponctuation) {
        Player p = findPlayer(id);
        p.setPoints(p.getPoints()+ponctuation);
        return pr.save(p);
    }

    public Player findPlayer(Integer id) {
        return pr.findById(id).orElseThrow(() -> new RuntimeException("Player not found!"));
    }
}
