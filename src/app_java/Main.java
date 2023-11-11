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
            System.out.println("2 - Вывести информацию о сотрудниках");
            System.out.println("3 - Вывести информация об автомобилях");
            System.out.println("4 - Вывести полную информацию об автосалоне");
            System.out.println("5 - Оформление сделки");
            System.out.println("6 - Вывести сделку");
            System.out.println("7 - Добавить сотрудника");
            System.out.println("8 - Добавить авто");
            System.out.println("9 - Удалить сотрудника");
            System.out.println("10 - Удалить авто");
            System.out.println("0 - Выход...");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dealership.inputDealership();
                    break;
                case 2:
                    dealership.outEmployeeDealership();
                    break;
                case 3:
                    dealership.outCarDealership();
                    break;
                case 4:
                    dealership.outAllInfoDealership();
                    break;
                case 5:
                    deal.inpDeal(dealership);
                    deal.outDeal();
                    break;
                case 6:
                    deal.outDeal();
                    break;
                case 7:
                    dealership.addEmployeesToDealership();
                    break;
                case 8:
                    dealership.addCarsToDealership();
                    break;
                case 9:
                    System.out.println("999");
                    break;
                case 10:
                    System.out.println("101010");
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
