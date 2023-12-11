package app_java;

import java.util.Scanner;
import static app_java.Func.InpAndCheckedInt;

public class Car {
    enum TechnicalCondition {
        NEW, USED, NEEDS_REPAIR, OUT_OF_SERVICE
    }

    private String brand_model; // Модель
    private String country; // Страна-производитель
    private int year; // Год производства
    private int price; // Цена
    private TechnicalCondition condition; // Техническое состояние
    private int quantity; // Количество

    // Конструктор без параметров
    public Car() {
        this.brand_model = "";
        this.country = "";
        this.year = 0;
        this.price = 0;
        this.condition = TechnicalCondition.NEW;
        this.quantity = 0;

    }

    //Конструтор с параметрами
    public Car(String brand_model, String country, int year, int price, TechnicalCondition condition, int quantity) {
        this.brand_model = brand_model;
        this.country = country;
        this.year = year;
        this.price = price;
        this.condition = condition;
        this.quantity = quantity;

    }

    //set и get
    public String getBrand_model() {
        return brand_model;
    }

    public void setBrand_model(String brand_model) {
        this.brand_model = brand_model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TechnicalCondition getCondition() {
        return condition;
    }

    public void setCondition(TechnicalCondition condition) {
        this.condition = condition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Метод для ввода информации об авто
    public void inputCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите марку и модель авто: ");
        setBrand_model(scanner.nextLine());

        System.out.print("Введите страну-производитель: ");
        setCountry(scanner.nextLine());

        setYear(InpAndCheckedInt("Введите год производства: "));

        setPrice(InpAndCheckedInt("Введите цену: "));

        TechnicalCondition inputCondition = null;
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";
        do {
            System.out.print("Введите состояние (NEW, USED, NEEDS_REPAIR, OUT_OF_SERVICE): ");
            String conditionInput = scanner.next();

            try {
                inputCondition = TechnicalCondition.valueOf(conditionInput);
            } catch (IllegalArgumentException e) {
                System.out.println(redColor + "Ошибка: 'Недопустимое состояние автомобиля'! Попробуйте снова." + resetColor);
            }
        } while (inputCondition == null);

        setQuantity(InpAndCheckedInt("Введите количество: "));

    }

    // Метод для вывода информации об авто
    public void outCar() {
        System.out.println("Марка и модель авто: " + getBrand_model());
        System.out.println("Страна-производитель: " + getCountry());
        System.out.println("Год производства: " + getYear());
        System.out.println("Цена: " + getPrice());
        System.out.println("Техническое состояние: " + getCondition());
        System.out.println("Количество: " + getQuantity());
    }
}
