package app_java;

import java.util.Scanner;

public class Dealership {
    private static final int MAX_EMPLOYEE = 100; // max сотрудников
    private static final int MAX_CARS = 100; // max авто
    private static int numEmployees; // Статическая переменная для количества сотрудников
    private static int numCars; // Статическая переменная для количества автомобилей

    private String name; // Название автосалона
    private String address; // Адрес автосалона
    private Employee[] employees = new Employee[MAX_EMPLOYEE]; // Список сотрудников
    private Car[] cars = new Car[MAX_CARS]; // Список имеющихся автомобилей

    // Конструктор без параметров
    public Dealership() {
        this.name = "";
        this.address = "";
    }

    // Конструктор с параметрами
    public Dealership(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Car[] getCars() {
        return cars;
    }

    public void inputDealership() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    __-- Создание автосалона --__");
        // Ввод данных об автосалоне
        System.out.print("Введите название автосалона: ");
        name = scanner.nextLine();
        System.out.print("Введите адрес автосалона: ");
        address = scanner.nextLine();

        // Ввод количества сотрудников и создание массива сотрудников
        System.out.print("Введите количество сотрудников: ");
        numEmployees = scanner.nextInt();

        System.out.println();
        System.out.println("  -- Ввод данных о сотрудниках --");
        for (int i = 0; i < numEmployees; ++i) {
            System.out.println("Сотрудник #" + (i + 1) + ":");
            employees[i] = new Employee();
            employees[i].inputEmployee();
            System.out.println();
        }

        // Ввод количества автомобилей и создание массива автомобилей
        System.out.print("Введите количество автомобилей: ");
        numCars = scanner.nextInt();

        System.out.println();
        System.out.println("  -- Ввод данных об автомобилях --");
        for (int i = 0; i < numCars; ++i) {
            System.out.println("Автомобиль #" + (i + 1) + ":");
            cars[i] = new Car();
            cars[i].inputCar();
            System.out.println();
        }
    }

    public void outAllInfoDealership(){
        System.out.println();
        if ((name != null && !name.isEmpty()) || (address != null && !address.isEmpty())) {
            System.out.println("    __-- Автосалон " + name + " --__");
            System.out.println("по адресу: " + address);
            outEmployeeDealership();
            outCarDealership();
        } else {
            System.out.println("Информация об автосалоне недоступна, так как отсутствует название или адрес.");
        }
    }

    public void outEmployeeDealership() {
        if (numEmployees == 0) {
            System.out.println("    __-- Сотрудники автосалона --__");
            System.out.println("В дилерском центре отсутствуют сотрудники.");
        } else {
            System.out.println("    __-- Сотрудники автосалона " + name + " --__");
            for (int i = 0; i < numEmployees; ++i) {
                System.out.println("Сотрудник #" + (i + 1) + ":");
                employees[i].outEmployee();
                System.out.println();
            }
        }
    }

    public void outCarDealership(){
        if (numCars == 0) {
            System.out.println("    __-- Автомобили автосалона --__");
            System.out.println("В дилерском центре отсутствуют автомобили.");
        } else {
            System.out.println("    __-- Автомобили автосалона " + name + " --__");
            for (int i = 0; i < numCars; ++i) {
                System.out.println("Автомобиль #" + (i + 1) + ":");
                cars[i].outCar();
                System.out.println();
            }
        }
        System.out.println();
    }

    public void outCarsChoice() {
        System.out.println("Автомобили в наличии:");
        for (int i = 0; i < numCars; i++) {
            System.out.println((i + 1) + ") " + cars[i].getBrand_model());
        }
    }

    public void outEmployeesChoice() {
        System.out.println("Список продавцов:");
        for (int i = 0; i < numEmployees; i++) {
            System.out.println((i + 1) + ") " + employees[i].getFirstName() + " " + employees[i].getLastName());
        }
    }

}