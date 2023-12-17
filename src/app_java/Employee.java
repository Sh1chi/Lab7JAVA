package app_java;

import java.util.Scanner;
import static app_java.Func.InpAndCheckedInt;

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
        super(first_name, last_name); //Вызов конструтора Базового класса
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
        String name = scanner.nextLine();

        System.out.print("Введите отчество сотрудника: ");
        String patronymic = scanner.nextLine();

        setFirstName(name, patronymic); // Используем перегруженный метод setFirstName

        System.out.print("Введите фамилию сотрудника: ");
        last_name = scanner.nextLine();

        System.out.print("Введите должность: ");
        position = scanner.nextLine();

        salary = InpAndCheckedInt("Введите зарплату: ");
    }

    // Метод для ввода информации о сотруднике
    public void outEmployee(){
        System.out.println("ФИО: " + first_name + " " +  last_name);
        System.out.println("Должность: " + position);
        System.out.println("Зарплата: " + salary);
    }

    // Метод toString
    @Override
    public String toString() {
        return "ФИО: " + first_name + " " + last_name +
                "\nДолжность: " + position +
                "\nЗарплата: " + salary;
    }

}
