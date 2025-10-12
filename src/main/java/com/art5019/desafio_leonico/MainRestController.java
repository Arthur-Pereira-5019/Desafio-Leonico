package com.art5019.desafio_leonico;

import com.art5019.desafio_leonico.entities.*;
import com.art5019.desafio_leonico.entities.dtos.Answer;
import com.art5019.desafio_leonico.entities.dtos.CreateMatchRequest;
import com.art5019.desafio_leonico.entities.dtos.JoinMatchRequest;
import com.art5019.desafio_leonico.services.MatchServices;
import com.art5019.desafio_leonico.services.QuestionServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    QuestionServices qs;

    @Autowired
    MatchServices ms;

    @GetMapping("/q/{id}")
    public QuestionDTO question(@PathVariable("id") Integer id) {
        return ms.currentQuestion(id);
    }

    @PostMapping("/q")
    public Question createQuestion(@RequestBody Question q) {
        return qs.saveQuestion(q);
    }

    @DeleteMapping("/q/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        qs.deleteQuestion(id);
    }

    @PostMapping("/q/answer")
    public Result answer(@RequestBody Answer a) {
        return qs.tryToGuess(a);
    }

    @PostMapping("/matchData/{id}")
    public Match matchData(@PathVariable("id") Integer id) {
        return ms.findById(id);
    }

    @PostMapping("/match/createMatch")
    public Match createMatch(CreateMatchRequest cmr, HttpServletResponse response) throws IOException {
        return ms.createMatch(cmr);
    }

    @PostMapping("/match/joinMatch")
    public Match createMatch(JoinMatchRequest jmr, HttpServletResponse response) throws IOException {
        return ms.joinMatch(jmr);
    }

}
