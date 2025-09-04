package com.art5019.desafio_leonico;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionServices {
    @Autowired
    QuestionRepository qr;

    public Question saveQuestion(Question q) {
        return qr.save(q);
    }

    public Question findQuestion(Long id) {
        return qr.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteQuestion(Long id) {
        qr.delete(findQuestion(id));
    }

}
