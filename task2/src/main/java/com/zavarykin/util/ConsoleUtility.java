package com.zavarykin.util;

import java.util.Scanner;

public final class ConsoleUtility {

    public static String readConsole() {
        String res = null;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            res = scanner.nextLine();
        }
        return res;
    }

    public static void writeStringToConsole(String string) {
        System.out.print(string);
    }
}
