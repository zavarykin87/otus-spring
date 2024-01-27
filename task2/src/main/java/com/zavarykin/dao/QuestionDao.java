package com.zavarykin.dao;

import com.zavarykin.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {

    List<Question> getAllFromFile(String fileName) throws IOException;
}
