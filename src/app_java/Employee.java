package app_java;

import java.util.Scanner;

public class Employee extends Person{
    private String position;   // Должность сотрудника
    private int salary;        // Зарплата сотрудника


    public Employee(){};

    public Employee(String first_name, String last_name) {
        super(first_name, last_name);
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

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


}
