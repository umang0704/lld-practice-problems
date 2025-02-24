package org.interview.utils;

import java.util.Scanner;

class ScannerUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Read user input as String
     */
    public static String readStringInput(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    /**
     * Read user input as Integer
     */
    public static int readIntInput(String prompt) {
        System.out.print(prompt);
        while (!SCANNER.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            SCANNER.next();
        }
        return SCANNER.nextInt();
    }

    /**
     * Read user input as Double
     */
    public static double readDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!SCANNER.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid decimal number.");
            SCANNER.next();
        }
        return SCANNER.nextDouble();
    }

    /**
     * Read user input as Boolean
     */
    public static boolean readBooleanInput(String prompt) {
        System.out.print(prompt);
        while (!SCANNER.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter true or false.");
            SCANNER.next();
        }
        return SCANNER.nextBoolean();
    }
}
