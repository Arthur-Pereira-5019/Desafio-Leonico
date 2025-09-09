package com.art5019.desafio_leonico;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionServices {
    @Autowired
    QuestionRepository qr;

    Random random = new Random();

    public Question saveQuestion(Question q) {
        return qr.save(q);
    }

    public Question findQuestion(Long id) {
        return qr.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteQuestion(Long id) {
        qr.delete(findQuestion(id));
    }

    public List<Question> findAll() {
        return qr.findAll();
    }

    public Question randomQuestion() {
        List<Question> questions = findAll();
        return questions.get(random.nextInt(0, questions.size()));
    }

}
