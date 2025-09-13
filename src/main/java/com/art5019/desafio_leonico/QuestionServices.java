package com.art5019.desafio_leonico;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class QuestionServices {
    @Autowired
    QuestionRepository qr;

    Random random = new Random();

    Logger logger = LoggerFactory.getLogger(QuestionServices.class);

    public Question saveQuestion(Question q) {
        return qr.save(q);
    }

    public Question findQuestion(Long id) {

        return qr.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Result tryToGuess(Answer a) {
        Question q = findQuestion(a.id());
        if(Objects.equals(q.answer, a.answer())) {
            logger.warn("won");
            return new Result(q.basePoints + a.remainingTime() * q.dificulty, true);
        }
        logger.warn("lost");
        return new Result(q.dificulty * a.triedTimes() * -1, false);
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

    public Question mock() {
        Question q = new Question();
        q.setAnswer("2");
        q.setType(QuestionType.OPEN);
        q.setBasePoints(3);
        q.setStatement("Quantos folhetos embrionários tem os cnidários");
        q.setExtraTime(1);
        q.setDificulty(2);
        return q;
    }

}
