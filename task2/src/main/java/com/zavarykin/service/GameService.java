package com.zavarykin.service;

import com.zavarykin.dao.QuestionDao;
import com.zavarykin.domain.Question;
import com.zavarykin.domain.User;

import java.io.IOException;
import java.util.List;

import static com.zavarykin.util.ConsoleUtility.readConsole;
import static com.zavarykin.util.ConsoleUtility.writeStringToConsole;

public class GameService {

    private final UserService userService;
    private final QuestionDao questionDao;
    private final String fileName;

    public GameService(UserService userService, QuestionDao questionDao, String fileName) {
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
        List<Question> questions = questionDao.getAllFromFile(fileName);
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
