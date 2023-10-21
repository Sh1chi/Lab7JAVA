package app_java;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("        -- Реализация АТД на языке Java --");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" -- Главное меню --");
        System.out.println("1 - Создать автосалон");
        System.out.println("2 - Нанять работников");
        System.out.println("3 - Внести автомобили в базу");
        System.out.println("4 - Оформление сделки");

        do {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while(input < 1 || input > 4)
        Scanner scanner = new Scanner(System.in);

        /*// Ввод данных о автосалоне
        System.out.print("Введите название автосалона: ");
        String dealershipName = scanner.nextLine();
        System.out.print("Введите адрес автосалона: ");
        String dealershipAddress = scanner.nextLine();*/

        // Ввод количества сотрудников и создание массива сотрудников
        System.out.print("Введите количество сотрудников: ");
        int numEmployees = scanner.nextInt();
        Employee[] employeeArray = new Employee[numEmployees];

        System.out.println();
        System.out.println("  -- Ввод данных о сотрудниках --");
        for (int i = 0; i < numEmployees; ++i) {
            String firstName, lastName, position;
            int salary;
            System.out.println("Сотрудник #" + (i + 1) + ":");
            employeeArray[i] = inputEmployee(scanner);
            System.out.println();
        }

        // Ввод количества автомобилей и создание массива автомобилей
        System.out.print("Введите количество автомобилей: ");
        int numCars = scanner.nextInt();
        Car[] carArray = new Car[numCars];

        System.out.println();
        System.out.println("  -- Ввод данных об автомобилях --");
        for (int i = 0; i < numCars; ++i) {
            String brandModel, country, condition;
            int year, price, quantity;
            System.out.println("Автомобиль #" + (i + 1) + ":");
            carArray[i] = inputCar(scanner);
            System.out.println();
        }
    }

    static Employee inputEmployee(Scanner scanner) {
        String firstName, lastName, position;
        int salary;
        System.out.print("Имя: ");
        firstName = scanner.next();
        System.out.print("Фамилия: ");
        lastName = scanner.next();
        System.out.print("Должность: ");
        position = scanner.next();
        System.out.print("Зарплата: ");
        salary = scanner.nextInt();
        return new Employee(firstName, lastName, position, salary);
    }

    static Car inputCar(Scanner scanner) {
        String brandModel, country, condition;
        int year, price, quantity;
        System.out.print("Марка и модель: ");
        brandModel = scanner.next();
        System.out.print("Страна производства: ");
        country = scanner.next();
        System.out.print("Год выпуска: ");
        year = scanner.nextInt();
        System.out.print("Цена: ");
        price = scanner.nextInt();
        System.out.print("Состояние: ");
        condition = scanner.next();
        System.out.print("Количество: ");
        quantity = scanner.nextInt();
        return new Car(brandModel, country, year, price, condition, quantity);
    }







        /*System.out.println("    -- Ввод информации о покупателе --");
        Customer customer1 = new Customer();
        customer1.inputCustomer();

        System.out.println("    -- Ввод информации о сотруднике --");
        Employee employee1 = new Employee();
        employee1.inputEmployee();

        System.out.println("    -- Ввод информации об автомобиле --");
        Car car1 = new Car();
        car1.inputCar();

        System.out.println("    -- Информация о покупателе --");
        customer1.outCustomer();

        System.out.println("    -- Информация о сотруднике --");
        employee1.outEmployee();

        System.out.println("    -- Информация об автомобиле --");
        car1.outCar();*/
    }

}
