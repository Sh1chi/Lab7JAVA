package app_java;

import java.util.Scanner;

public class Customer extends Person{
    private String phone_number;  // Номер телефона покупателя

    // Конструктор без параметров
    public Customer(){
        this.phone_number = "";
    };

    //Конструтор с параметрами
    public Customer(String first_name, String last_name, String phone_number){
        super(first_name,last_name); //Вызов конструтора Базового класса
        this.phone_number = phone_number;

    }

    // Метод для установки информации о номере телефона
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    // Метод для получения информации о номере телефона
    public String getPhone_number() {
        return phone_number;
    }

    // Метод для ввода информации о покупателе
    // Метод для ввода информации о покупателе
    public void inpCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя клиента: ");
        String name = scanner.nextLine();

        System.out.print("Введите отчество клиента: ");
        String patronymic = scanner.nextLine();

        setFirstName(name, patronymic); // Используем перегруженный метод setFirstName

        System.out.print("Введите фамилию клиента: ");
        last_name = scanner.nextLine();

        System.out.print("Введите номер телефона: ");
        phone_number = scanner.nextLine();
    }

    // Метод для вывода информации о покупателе
    public void outCustomer() {
        System.out.println("Покупатель:" + first_name + " " + last_name);
        System.out.println("Номер телефона: " + phone_number);
    }


}
