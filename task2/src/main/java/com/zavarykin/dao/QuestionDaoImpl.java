package com.zavarykin.dao;

import com.zavarykin.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionDaoImpl implements QuestionDao {

    public List<Question> getAllFromFile(String fileName) throws IOException {
        List<String> listStr = readFile(openFile(fileName));
        return listStr.stream()
                .map(mapStringToQuestion)
                .collect(Collectors.toList());
    }

    private InputStream openFile(String fileName) {
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }

    private List<String> readFile(InputStream inputStream) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();
        while (str != null) {
            result.add(str);
            str = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStream.close();
        return result;
    }

    private Function<String, Question> mapStringToQuestion = str -> {
        try {
            String[] arr = str.split(",");
            int num = Integer.parseInt(arr[0]);
            String text = arr[1];
            String opt1 = arr[2];
            String opt2 = arr[3];
            String opt3 = arr[4];
            String opt4 = arr[5];
            String rightAnswer = arr[6];
            Question question = new Question(num, text, opt1, opt2, opt3, opt4, rightAnswer);
            return question;
        } catch (Exception e) {
            return null;
        }
    };
}
