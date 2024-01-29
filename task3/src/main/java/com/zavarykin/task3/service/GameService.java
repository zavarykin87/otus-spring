package com.zavarykin.task3.service;

import com.zavarykin.task3.dao.QuestionDao;
import com.zavarykin.task3.domain.Question;
import com.zavarykin.task3.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.zavarykin.task3.util.ConsoleUtility.readConsole;
import static com.zavarykin.task3.util.ConsoleUtility.writeStringToConsole;


@Service
@PropertySource("classpath:application.yml")
public class GameService {

    private final UserService userService;
    private final QuestionDao questionDao;
    private final String fileName;

    public GameService(UserService userService, QuestionDao questionDao,
                       @Value("${file.name}") String fileName) {
        this.userService = userService;
        this.questionDao = questionDao;
        this.fileName = fileName;
    }

    public void startGame() throws IOException {
        createUser();
        int score = playAndGetScore();
        System.out.println();
        writeStringToConsole("you scored " + score + " points");
    }

    private User createUser() {
        writeStringToConsole("Enter your firstName:");
        System.out.println();
        String first = readConsole();
        writeStringToConsole("Enter your lastName");
        System.out.println();
        String last = readConsole();
        return userService.create(first, last);
    }

    private int playAndGetScore() throws IOException {
        int score = 0;
        writeStringToConsole("Answer the questions:");
        System.out.println();
        List<Question> questions = questionDao.getAllQuestionsFromFile(fileName);
        for (Question question : questions) {
            writeStringToConsole(question.getText());
            System.out.println();
            writeStringToConsole(question.getOption1());
            System.out.println();
            writeStringToConsole(question.getOption2());
            System.out.println();
            writeStringToConsole(question.getOption3());
            System.out.println();
            writeStringToConsole(question.getOption4());
            System.out.println();
            String answer = readConsole();
            if (answer.equals(question.getRightAnswer())) {
                score++;
            }
        }
        return score;
    }
}
