package com.zavarykin.task3.dao;

import com.zavarykin.task3.domain.Question;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class QuestionDaoFile implements QuestionDao {

    @Override
    public List<Question> getAllQuestionsFromFile(String fileName) throws IOException {
        if (fileName.trim().isEmpty() || fileName == null) {
            throw new IOException("Не указано имя файла");
        }
        List<String> listStr = readFile(openFile(fileName));
        return listStr.stream()
                .map(mapStringToQuestion)
                .filter(question -> question != null)
                .collect(Collectors.toList());
    }

    private InputStream openFile(String fileName) {
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }

    private List<String> readFile(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("Файл не найден");
        }
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
