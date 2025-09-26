package com.art5019.desafio_leonico;

import com.art5019.desafio_leonico.entities.*;
import com.art5019.desafio_leonico.services.MatchServices;
import com.art5019.desafio_leonico.services.QuestionServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    QuestionServices qs;

    @Autowired
    MatchServices ms;

    @GetMapping("/q")
    public Question question() {
        return qs.randomQuestion();
    }

    @PostMapping("/q")
    public Question createQuestion(@RequestBody Question q) {
        return qs.saveQuestion(q);
    }

    @DeleteMapping("/q/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        qs.deleteQuestion(id);
    }

    @GetMapping("/q/mock")
    public Question mock() {
        return qs.mock();
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
    public CreateMatchReturn createMatch(CreateMatchRequest cmr, HttpServletResponse response) throws IOException {
        CreateMatchReturn createMatchReturn = new CreateMatchReturn(ms.createMatch(cmr));
        return createMatchReturn;
    }
}
