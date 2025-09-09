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
    public Question createQuestion(Question q) {
        return qs.saveQuestion(q);
    }

    @DeleteMapping("/api/q")
    public void deleteQuestion(Long id) {
        qs.deleteQuestion(id);
    }

}
