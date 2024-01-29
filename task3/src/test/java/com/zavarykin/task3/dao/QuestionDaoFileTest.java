package com.zavarykin.task3.dao;

import com.zavarykin.task3.domain.Question;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDaoFileTest {

    private final QuestionDaoFile questionDaoFile = new QuestionDaoFile();

    @Test
    void getAllQuestionsFromFileTest() throws IOException {

        List<Question> result = questionDaoFile.getAllQuestionsFromFile("questions.csv");

        assertEquals(5, result.size());
    }

    @Test
    void notFileNameExceptionTest() {

        Exception exception = assertThrows(IOException.class, () -> questionDaoFile.getAllQuestionsFromFile("    "));

        assertEquals("Не указано имя файла", exception.getMessage());
    }

    @Test
    void fileNotFoundExcepionTest() {

        Exception exception = assertThrows(IOException.class, () -> questionDaoFile.getAllQuestionsFromFile("notFound.txt"));

        assertEquals("Файл не найден", exception.getMessage());
    }
}