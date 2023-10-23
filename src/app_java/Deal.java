package app_java;

import java.util.Scanner;

public class Deal {
    private int deal_number;          // Номер сделки
    private String date;              // Дата сделки
    private Employee employee;         // Продавец
    private Customer customer;          // Покупатель
    private Car car;            // Проданный автомобиль
    private int transaction_amount;  // Сумма сделки

    public Deal() {
        // Инициализация объекта Deal без параметров
        this.deal_number = 0;
        this.date = "";
        this.employee = null;
        this.customer = null;
        this.car = null;
        this.transaction_amount = 0;
    }

    public int getDeal_number() {
        return deal_number;
    }

    public void setDeal_number(int deal_number) {
        this.deal_number = deal_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public void inpDeal(Dealership dealership) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("    -- Производится оформление договора купли-продажи авто --");
        System.out.print("Введите номер сделки: ");
        deal_number = scanner.nextInt();
        scanner.nextLine(); // Очистить буфер после ввода числа

        System.out.print("Введите дату сделки: ");
        date = scanner.nextLine();

        // Вывод списка доступных продавцов
        dealership.outEmployeesChoice();

        int employeeChoice;
        do {
            System.out.print("Выберите номер продавца из списка: ");
            employeeChoice = scanner.nextInt();
            if (employeeChoice < 1 || employeeChoice > dealership.getEmployees().length) {
                System.out.println("Неверная команда...");
            }
        } while (employeeChoice < 1 || employeeChoice > dealership.getEmployees().length);

        employee = dealership.getEmployees()[employeeChoice - 1];

        // Ввод информации о покупателе
        customer = new Customer();
        customer.inpCustomer();

        // Вывод списка доступных автомобилей
        dealership.outCarsChoice();

        int carChoice;
        do {
            System.out.print("Выберите номер автомобиля из списка: ");
            carChoice = scanner.nextInt();
            if (carChoice < 1 || carChoice > dealership.getCars().length) {
                System.out.println("Неверная команда...");
            }
        } while (carChoice < 1 || carChoice > dealership.getCars().length);

        car = dealership.getCars()[carChoice - 1];

        System.out.print("Введите сумму сделки: ");
        transaction_amount = scanner.nextInt();
        scanner.nextLine(); // Очистить буфер после ввода числа
    }

    public void outDeal() {
        System.out.println();
        System.out.println("    __-- Договор купли-продажи авто --__");
        System.out.println("Cделки # " + getDeal_number());
        System.out.println("Дата сделки: " + getDate());
        System.out.println("Продавец: " + getEmployee().getFirstName() + " " + getEmployee().getLastName());
        System.out.println("Покупатель: " + getCustomer().getFirstName() + " " + getCustomer().getLastName());
        System.out.println("Проданный автомобиль: " + getCar().getBrand_model());
        System.out.println("Сумма сделки: " + getTransaction_amount());
        System.out.println();
    }

}
