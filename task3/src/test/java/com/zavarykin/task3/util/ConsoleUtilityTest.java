package com.zavarykin.task3.util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

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