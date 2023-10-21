package app_java;

import java.util.Scanner;

public class Customer extends Person{
    private String phone_number;  // Номер телефона покупателя


    public Customer(){};

    public Customer(String first_name, String last_name, String phone_number){
        super(first_name,last_name);
        setPhone_number(phone_number);

    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    // Функция ввода информации о покупателе в адреса меременных
    public void inputCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя клиента: ");
        setFirstName(scanner.nextLine());

        System.out.print("Введите фамилию клиента: ");
        setLastName(scanner.nextLine());

        System.out.print("Введите номера телефона: ");
        setPhone_number(scanner.nextLine());

    }


}
