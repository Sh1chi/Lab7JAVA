package app_java;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit_programm = false;
        int choice;
        Dealership dealership = new Dealership();
        Deal deal = new Deal();

        System.out.println("        -- Реализация АТД на языке Java --");
        System.out.println();

        do {
            System.out.println(" -- Главное меню --");
            System.out.println("1 - Создать автосалон");
            System.out.println("2 - Оформление сделки");
            System.out.println("3 - Добавить сотрудника");
            System.out.println("4 - Добавить авто");
            System.out.println("5 - Удалить сотрудника");
            System.out.println("6 - Удалить авто");
            System.out.println("7 - Вывести информацию о сотрудниках");
            System.out.println("8 - Вывести информация об автомобилях");
            System.out.println("9 - Вывести полную информацию об автосалоне");
            System.out.println("10 - Вывести сделку");
            System.out.println("0 - Выход...");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dealership.inputDealership();
                    break;
                case 2:
                    deal.inpDeal(dealership);
                    break;
                case 3:
                    dealership.addEmployeesToDealership();
                    break;
                case 4:
                    dealership.addCarsToDealership();
                    break;
                case 5:
                    dealership.removeEmployeeFromDealership();
                    break;
                case 6:
                    dealership.removeCarFromDealership();
                    break;
                case 7:
                    dealership.outEmployeeDealership();
                    break;
                case 8:
                    dealership.outCarDealership();
                    break;
                case 9:
                    dealership.outAllInfoDealership();
                    break;
                case 10:
                    deal.outDeal();
                    break;
                case 0:
                    System.out.println("Осуществляется выход...");
                    exit_programm = true;
                    break;
                default:
                    System.out.println("Неверная команда...");
                    break;
            }
        }while (choice < 0 || choice > 5 || !exit_programm);
        }
    }
