package org.eshop;

import java.util.Scanner;

class ConsoleHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int askInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }
}