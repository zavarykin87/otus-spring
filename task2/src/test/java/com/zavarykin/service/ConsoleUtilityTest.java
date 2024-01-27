package com.zavarykin.service;

import com.zavarykin.util.ConsoleUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConsoleUtilityTest {

    @Test
    public void readConsoleTest() {
        String message = "hello";
        System.setIn(new ByteArrayInputStream(message.getBytes()));
        assertEquals("hello", ConsoleUtility.readConsole());
    }

    @Test
    public void writeToConsoleTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ConsoleUtility.writeStringToConsole("hello");
        assertEquals("hello", out.toString());

    }

}