package com.library.ui;

import java.util.Scanner;

public class ConsoleInputHandler {
    private final Scanner scanner;

    public ConsoleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Lütfen geçerli bir sayı girin!");
            }
        }
    }

    public int getIntInputWithDefault(String prompt, int defaultValue) {
        while (true) {
            try {
                System.out.print(prompt + " [" + defaultValue + "]: ");
                String input = scanner.nextLine();
                return input.isEmpty() ? defaultValue : Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Lütfen geçerli bir sayı girin!");
            }
        }
    }

    public String getStringInputWithDefault(String prompt, String defaultValue) {
        System.out.print(prompt + " [" + defaultValue + "]: ");
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

}
