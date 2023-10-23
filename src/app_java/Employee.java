package app_java;

import java.util.Scanner;

public class Employee extends Person{
    private String position;   // Должность сотрудника
    private int salary;        // Зарплата сотрудника

    // Конструктор без параметров
    public Employee(){
        this.position = "";
        this.salary = 0;
    };

    //Конструтор с параметрами
    public Employee(String first_name, String last_name, String position, int salary) {
        super(first_name, last_name);
        this.position = position;
        this.salary = salary;
    }

    // Метод для получения информации о должности
    public String getPosition() {
        return position;
    }

    // Метод для установки информации о должности
    public void setPosition(String position) {
        this.position = position;
    }

    // Метод для получения информации о зарплате
    public int getSalary() {
        return salary;
    }

    // Метод для установки информации о зарплате
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Метод для ввода информации о сотруднике
    public void inputEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя сотрудника: ");
        setFirstName(scanner.nextLine());

        System.out.print("Введите фамилию сотрудника: ");
        setLastName(scanner.nextLine());

        System.out.print("Введите должность: ");
        setPosition(scanner.nextLine());

        System.out.print("Введите зарплату: ");
        setSalary(scanner.nextInt());

    }

    // Метод для ввода информации о сотруднике
    public void outEmployee(){
        System.out.println("Имя и фамилия: " + getFirstName() + " " +  getLastName());
        System.out.println("Должность: " + getPosition());
        System.out.println("Зарплата: " + getSalary());
    }


}
