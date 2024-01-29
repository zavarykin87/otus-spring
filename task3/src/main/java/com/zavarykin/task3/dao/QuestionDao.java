package com.zavarykin.task3.dao;

import com.zavarykin.task3.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {

    List<Question> getAllQuestionsFromFile(String fileName) throws IOException;

}
