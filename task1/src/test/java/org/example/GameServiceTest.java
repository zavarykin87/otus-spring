package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Test
    public void constructorGameServiceTest() {
        GameService gameService = new GameService("questions.csv");
        assertEquals("questions.csv", gameService.getFileName());
    }

    @Test
    public void constructorGameServiceExceptionTest() {
        try {
            GameService gameService = new GameService("");
        } catch (IllegalArgumentException exception) {
            assertEquals("Имя файла не может быть пустым", exception.getMessage());
        }
    }

    @Test
    public void openFileTest() {
        GameService gameService = new GameService("questions.csv");
        Object object = gameService.openFile();
        boolean b = object instanceof InputStream;
        assertEquals(true, b);
    }

    @Test
    public void readFileTest() throws IOException {
        GameService gameService = new GameService("questions.csv");
        InputStream inputStream = gameService.openFile();
        assertEquals(6, gameService.readFile(inputStream).size());
    }
}