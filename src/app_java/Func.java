package app_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Func {
    // Метод для ввода числовых значений с защитой от некорректного ввода
    public static int InpAndCheckedInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: 'Некорректный ввод'!");
                System.out.print(prompt);
                scanner.next(); // Очистка буфера от некорректного ввода
            }
            number = scanner.nextInt();

            // Добавление проверки на отрицательное число
            if (number < 0) {
                System.out.println("Ошибка: 'Введено отрицательное число'!");
                continue;
            }
            break;
        } while (true);

        return number;
    }

    public static boolean confirmAction(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        do {
            System.out.println(prompt);
            answer = scanner.nextLine().toLowerCase();

            if (answer.equals("да")) {
                return true;  // Возвращаем true при подтверждении
            } else if (answer.equals("нет")) {
                return false;  // Возвращаем false при отмене
            } else {
                System.out.println("\nОшибка: 'Некорректный ввод'\nПожалуйста, введите 'Да' или 'Нет'.\n");
            }

        } while (!answer.equals("да") && !answer.equals("нет"));

        return false;  // Возвращаем false, если цикл закончится, не достигнув "да" или "нет"
    }

    public static void clearingСonsole(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


}
