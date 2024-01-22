package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final String fileName;

    public GameService(String fileName) {
        if (fileName.trim().isEmpty() || fileName == null) {
            throw new IllegalArgumentException("Имя файла не может быть пустым");
        } else {
            this.fileName = fileName;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public InputStream openFile() {
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }

    public List<String> readFile(InputStream inputStream) throws IOException {
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

    public void writeToConsole(List<String> questions) {
        for (String s : questions) {
            System.out.println(s);
        }
    }

    public void play() throws IOException {
        writeToConsole(readFile(openFile()));
    }


}
