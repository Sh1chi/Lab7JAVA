package app_java;

import java.util.InputMismatchException;
import java.util.Scanner;

import static app_java.Func.*;

public class Deal implements Cloneable{
    private static int deal_number = 0;
    private int transaction_code;          // Номер сделки
    private String date;              // Дата сделки
    private Employee employee;         // Продавец
    private Customer customer;          // Покупатель
    private Car car;            // Проданный автомобиль
    private int transaction_amount;  // Сумма сделки

    public Deal() {
        // Инициализация объекта Deal без параметров
        this.transaction_code = 0;
        this.date = "";
        this.employee = null;
        this.customer = null;
        this.car = null;
        this.transaction_amount = 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Deal dealClone() throws CloneNotSupportedException {
        Deal clonedDeal = (Deal) super.clone();
        // Клонируем объекты внутри сделки (мелкое клонирование)
        clonedDeal.employee = (Employee) employee.clone();
        clonedDeal.customer = (Customer) customer.clone();
        clonedDeal.car = (Car) car.clone();
        return clonedDeal;
    }

    private static int generateDealNumber() {
        return deal_number++;
    }

    public static int getDealNumber() {
        return deal_number;
    }

    // Метод для получения заработка автосалона по текущей сделке
    public int getProfit() {
        return CarSaleCalculator.calculateProfit(transaction_amount);
    }

    public int getTransaction_code() {
        return transaction_code;
    }

    public void setTransaction_code(int transaction_code) {
        this.transaction_code = transaction_code;
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

    // Метод ввода сделки
    public void inpDeal(Dealership dealership, Deal[] dealsArray, String[][] carData) {
        Scanner scanner = new Scanner(System.in);
        // Проверка наличия созданного автосалона
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        try {
            if (!dealership.isDealershipCreated()) {
                throw new IllegalStateException("Автосалон отсутствует. Пожалуйста, создайте автосалон перед оформлением сделки");
            }

            if (Dealership.getNumEmployees() == 0) {
                throw new IllegalStateException("Сотрудники отсутствуют. Пожалуйста, добавьте сотрудников перед оформлением сделки");
            }

            if (Dealership.getNumCars() == 0) {
                throw new IllegalStateException("Автомобили отсутствуют. Пожалуйста, добавьте автомобили перед оформлением сделки");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }

        System.out.println();
        System.out.println("    -- Производится оформление договора купли-продажи авто --");

        // Используйте статический метод для генерации уникального номера сделки
        generateDealNumber();

        System.out.print("Введите код сделки: ");
        transaction_code = scanner.nextInt();
        scanner.nextLine(); // Очистить буфер после ввода числа

        System.out.print("Введите дату сделки: ");
        date = scanner.nextLine();

        // Вывод списка доступных продавцов
        dealership.outEmployeesChoice();

        int employeeChoice;
        do {
            employeeChoice = InpAndCheckedInt("Выберите номер продавца из списка: ");
            if (employeeChoice == 0 || employeeChoice > Dealership.getNumEmployees()) {
                System.out.println("Неверная команда...");
            }
        } while (employeeChoice < 1 || employeeChoice > Dealership.getNumEmployees());

        employee = dealership.getEmployees()[employeeChoice - 1];

        // Ввод информации о покупателе
        customer = new Customer();
        customer.inpPersonInfo();

        // Вывод списка доступных автомобилей
        dealership.outCarsChoice();

        int carChoice;
        do {
            carChoice = InpAndCheckedInt("Выберите номер автомобиля из списка: ");
            if (carChoice > Dealership.getNumCars()) {
                System.out.println("Неверная команда...");
            }
        } while (carChoice < 1 || carChoice > Dealership.getNumCars());

        car = dealership.getCars()[carChoice - 1];

        System.out.print("Введите сумму сделки: ");
        transaction_amount = scanner.nextInt();
        scanner.nextLine(); // Очистить буфер после ввода числа

        // Добавление сделки в массив сделок
        for (int i = 0; i < deal_number; i++) {
            if (dealsArray[i] == null) {
                dealsArray[i] = this;
                break;
            }
        }

        // Добавление марки авто и его цены в массив carData
        carData[deal_number - 1][0] = String.valueOf(transaction_code);
        carData[deal_number - 1][1] = dealership.getCars()[carChoice - 1].getBrand_model();
        carData[deal_number - 1][2] = String.valueOf(transaction_amount * 0.05);
    }

    public static void outProfitDealership(String[][] carData, Dealership dealership) {
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";
        try {
            if (!dealership.isDealershipCreated()) {
                throw new IllegalStateException("Автосалон отсутствует. Пожалуйста, создайте автосалон перед добавлением сотрудников");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }
        System.out.println("   __--Прибыль автосалона--__\nДвумерный массив\n");
        double total_profit = 0.0;
        for (int i = 0; i < deal_number; ++i) {
            System.out.println("Сделка #" + carData[i][0]);
            System.out.println("Марка: " + carData[i][1]);
            System.out.println("Прибыль: " + carData[i][2]);
            double profitDouble = Double.parseDouble(carData[i][2]); // Преобразование в double
            total_profit += profitDouble; // Сложение с total_profit
            System.out.println();
        }
        System.out.println("Общая прибыль автосалона: " + total_profit);
        System.out.println();
    }

    // Метод для очистки массива сделок
    public static void clearDealsArray(Deal[] dealsArray) {
        if (!confirmAction("Вы точно хотите удалить историю сделок? (Да/Нет)")) {
            System.out.println("Удаление отменено.");
            return;
        }

        for (int i = 0; i < deal_number; i++) {
            dealsArray[i] = null;
        }
        deal_number = 0;
        CarSaleCalculator.setTotalProfit(0);
        System.out.println("История сделок очищена.");
    }

    // Метод для вывода заработка по каждой сделке и общего заработка
    public static void outProfitDealership(Deal[] dealsArray, Dealership dealership) {
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";
        try {
            if (!dealership.isDealershipCreated()) {
                throw new IllegalStateException("Автосалон отсутствует. Пожалуйста, создайте автосалон перед добавлением сотрудников");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }
        System.out.println();
        System.out.println("    __-- Прибыль автосалона --__\nВспомогательный класс");

        for (int i = 0; i < deal_number; i++) {
            Deal deal = dealsArray[i];
            if (deal != null) {
                int profit = CarSaleCalculator.calculateProfit(deal.getTransaction_amount());
                System.out.println("Cделка #" + deal.getTransaction_code() + ": " + profit);
                CarSaleCalculator.addToTotalProfit(deal.getTransaction_amount());
            }
        }
        int total_profit = CarSaleCalculator.getTotalProfit();
        System.out.println();
        System.out.println("Общий заработок автосалона: " + total_profit);
    }

    // Метод вывода сделки
    public void outAllDeals(Deal[] dealsArray) {
        System.out.println();
        System.out.println("    __-- Договоры купли-продажи авто --__");

        if (deal_number == 0){
            System.out.println("История сделок отсутствует.");
        }
        for (int i = 0; i < deal_number; i++) {
            Deal deal = dealsArray[i];
            if (deal != null) {
                System.out.println("Cделка #" + deal.getTransaction_code());
                System.out.println("Дата сделки: " + deal.getDate());
                System.out.println("Продавец: " + deal.getEmployee().getFirstName() + " " + deal.getEmployee().getLastName());
                System.out.println("Покупатель: " + deal.getCustomer().getFirstName() + " " + deal.getCustomer().getLastName());
                System.out.println("Проданный автомобиль: " + deal.getCar().getBrand_model());
                System.out.println("Сумма сделки: " + deal.getTransaction_amount());
                System.out.println();
            }
        }
    }

    public static void cloneDeal(Deal[] dealsArray, Dealership dealership){
        Scanner scanner = new Scanner(System.in);
        if (dealership.isDealershipCreated() && deal_number > 0) {
            System.out.println("    __--Клонирование сделок--__");

            // Выводим список созданных сделок
            System.out.println("История сделок:");
            for (int i = 0; i < deal_number; i++) {
                System.out.println((i + 1) + ". Сделка #" + dealsArray[i].getTransaction_code());
            }

            int dealChoice;
            do {
                dealChoice = InpAndCheckedInt("Выберите номер сделки для клонирования: ");
                if (dealChoice > deal_number) {
                    System.out.println("Неверная команда...");
                }
            } while (dealChoice < 1 || dealChoice > Dealership.getNumCars());


            try {
                // Клонирование сделки
                Deal clonedDeal = dealsArray[dealChoice - 1].dealClone();
                dealsArray[deal_number++] = clonedDeal;
                System.out.println("Клонирование завершено успешно!");
            } catch (CloneNotSupportedException e) {
                System.out.println("\nОшибка при клонировании сделки: " + e.getMessage() + "\n");
            }

        } else {
            System.out.println("История сделок пуста...\n");
        }
    }

}
