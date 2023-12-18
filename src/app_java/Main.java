package app_java;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static app_java.Func.*;


public class Main {
    private static final int MAX_DEAL = 100; // max сделок

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit_programm = false;
        int choice;
        Dealership dealership = new Dealership();
        ArrayList<Deal> dealsList = new ArrayList<>(); // Используем ArrayList для хранения сделок
        String[][] carData = new String[MAX_DEAL][3];

        System.out.println("        -- Реализация АТД на языке Java --");
        System.out.println();

        do {
            System.out.println(" -- Главное меню --");
            System.out.println("1 - Создать автосалон");
            System.out.println("2 - Оформить сделку");
            System.out.println("3 - Добавить сотрудника");
            System.out.println("4 - Добавить авто");
            System.out.println("5 - Удалить сотрудника");
            System.out.println("6 - Удалить авто");
            System.out.println("7 - Вывести информацию о сотрудниках");
            System.out.println("8 - Вывести информация об автомобилях");
            System.out.println("9 - Вывести полную информацию об автосалоне");
            System.out.println("10 - Вывести историю сделок");
            System.out.println("11 - Очистить историю сделок автосалона");
            System.out.println("12 - Прибыль автосалона(Вспомогательный класс)");
            System.out.println("13 - Прибыль автосалона(Двумерный массив)");
            System.out.println("14 - Клонирование сделок");
            System.out.println("15 - Демонстрация работы шаблона класса ShablonTestTransport");
            System.out.println("16 - Поиск сделки");
            System.out.println("0 - Выход...\n");

            choice = InpAndCheckedInt("Выберите действие: ");

            switch (choice) {
                case 1:
                    clearingСonsole();
                    dealership.inputDealership();
                    break;
                case 2:
                    clearingСonsole();
                    Deal newDeal = new Deal();
                    newDeal.inpDeal(dealership, dealsList, carData);
                    break;
                case 3:
                    clearingСonsole();
                    dealership.addEmployeesToDealership();
                    break;
                case 4:
                    clearingСonsole();
                    dealership.addCarsToDealership();
                    break;
                case 5:
                    clearingСonsole();
                    dealership.removeEmployeeFromDealership();
                    break;
                case 6:
                    clearingСonsole();
                    dealership.removeCarFromDealership();
                    break;
                case 7:
                    clearingСonsole();
                    dealership.outEmployeeDealership();
                    break;
                case 8:
                    clearingСonsole();
                    dealership.outCarDealership();
                    break;
                case 9:
                    clearingСonsole();
                    dealership.outAllInfoDealership();
                    break;
                case 10:
                    clearingСonsole();
                    Deal dealPrinter = new Deal();
                    dealPrinter.outAllDeals(dealsList);
                    break;
                case 11:
                    clearingСonsole();
                    Deal.clearDealsList(dealsList);
                    break;
                case 12:
                    clearingСonsole();
                    Deal.outProfitDealership(dealsList, dealership);
                    break;
                case 13:
                    clearingСonsole();
                    Deal.outProfitDealership(carData, dealership);
                    break;
                case 14:
                    clearingСonsole();
                    Deal.cloneDeal(dealsList, dealership);
                    break;
                case 15:
                    clearingСonsole();
                    demonstrateShablonClass();
                    break;
                case 16:
                    clearingСonsole();
                    Deal.findAndOutputDealByTransactionCode(dealsList);
                    break;
                case 0:
                    System.out.println("Осуществляется выход...");
                    exit_programm = true;
                    break;
                default:
                    System.out.println("Ошибка: 'Неверная команда'!");
                    break;
            }
            if (!exit_programm) {
                System.out.println("\nНажмите 'ENTER' для продолжения...");
                scanner.nextLine(); // Ожидание ввода пользователя
                clearingСonsole();
            }
        }while (choice < 0 || choice > 5 || !exit_programm);
        }
    }
