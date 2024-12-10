package project.utils;

import java.util.Scanner;

public class ConsoleUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextInt();
    }
}

