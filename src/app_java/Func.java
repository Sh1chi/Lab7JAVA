package app_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Func {
    // Метод для ввода числовых значений с защитой от некорректного ввода
    public static int InpAndCheckedInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        while (true) {
            try {
                System.out.print(prompt); // ANSI-код для красного цвета текста
                int number = scanner.nextInt();

                if (number < 0) {
                    throw new IllegalArgumentException("\u001B[31mВведено отрицательное число\u001B[0m"); // ANSI-код для сброса цвета текста
                }

                return number;
            } catch (IllegalArgumentException e) {
                String errorMessage = e.getMessage();
                System.out.println(redColor + "Ошибка: '" + errorMessage + resetColor + redColor + "'!"+ resetColor);
            } catch (java.util.InputMismatchException e) {
                System.out.println("\u001B[31mОшибка: 'Некорректный ввод'!\u001B[0m"); // ANSI-код для сброса цвета текста
                scanner.next(); // Очистка буфера от некорректного ввода
            }
        }
    }

    public static boolean confirmAction(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        while (true) {
            try {
                System.out.println(prompt);
                String answer = scanner.nextLine().toLowerCase();

                if (answer.equals("да")) {
                    return true;  // Возвращаем true при подтверждении
                } else if (answer.equals("нет")) {
                    return false;  // Возвращаем false при отмене
                } else {
                    throw new IllegalArgumentException("'Некорректный ввод'! Пожалуйста, введите 'Да' или 'Нет'.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(redColor + "Ошибка: '" + e.getMessage()  + resetColor);
            }
        }
    }

    public static void clearingСonsole(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
