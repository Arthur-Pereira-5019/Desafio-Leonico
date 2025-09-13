package com.art5019.desafio_leonico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController {

    @Autowired
    QuestionServices qs;

    @GetMapping("/api/q")
    public Question question() {
        return qs.randomQuestion();
    }

    @PostMapping("/api/q")
    public Question createQuestion(@RequestBody Question q) {
        return qs.saveQuestion(q);
    }

    @DeleteMapping("/api/q/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        qs.deleteQuestion(id);
    }

    @GetMapping("/api/q/mock")
    public Question mock() {
        return qs.mock();
    }

    @PostMapping("/api/q/answer")
    public Result answer(@RequestBody Answer a) {
        return qs.tryToGuess(a);
    }

}
