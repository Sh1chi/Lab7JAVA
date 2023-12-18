package app_java;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
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
    public void inpDeal(Dealership dealership, ArrayList<Deal> dealsList, String[][] carData) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor);
            return;
        }

        System.out.println();
        System.out.println("    -- Производится оформление договора купли-продажи авто --");

        generateDealNumber();

        System.out.print("Введите код сделки: ");
        transaction_code = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите дату сделки: ");
        date = scanner.nextLine();

        dealership.outEmployeesChoice();
        int employeeChoice;
        do {
            employeeChoice = InpAndCheckedInt("Выберите номер продавца из списка: ");
            if (employeeChoice == 0 || employeeChoice > Dealership.getNumEmployees()) {
                System.out.println("Неверная команда...");
            }
        } while (employeeChoice < 1 || employeeChoice > Dealership.getNumEmployees());

        employee = dealership.getEmployees()[employeeChoice - 1];

        customer = new Customer();
        customer.inpPersonInfo();

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
        scanner.nextLine();

        dealsList.add(this);

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
    public static void clearDealsList(ArrayList<Deal> dealsList) {
        if (!confirmAction("Вы точно хотите удалить историю сделок? (Да/Нет)")) {
            System.out.println("Удаление отменено.");
            return;
        }

        dealsList.clear();
        CarSaleCalculator.setTotalProfit(0);
        System.out.println("История сделок очищена.");
    }

    // Метод для вывода заработка по каждой сделке и общего заработка
    public static void outProfitDealership(ArrayList<Deal> dealsList, Dealership dealership) {
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
        System.out.println("    __-- Прибыль автосалона --__(Вспомогательный класс)");

        int totalProfit = 0;
        for (Deal deal : dealsList) {
            int profit = CarSaleCalculator.calculateProfit(deal.getTransaction_amount());
            System.out.println("Cделка #" + deal.getTransaction_code() + ": " + profit);
            totalProfit += profit;
            CarSaleCalculator.addToTotalProfit(deal.getTransaction_amount());
        }

        System.out.println();
        System.out.println("Общий заработок автосалона: " + totalProfit);
    }

    // Метод вывода сделки
    public void outAllDeals(ArrayList<Deal> dealsList) {
        System.out.println();
        System.out.println("    __-- Договоры купли-продажи авто --__");

        if (dealsList.isEmpty()) {
            System.out.println("История сделок отсутствует.");
        } else {
            // Сортировка списка сделок по transaction_code
            dealsList.sort(Comparator.comparingInt(Deal::getTransaction_code));

            // Вывод отсортированных сделок
            for (Deal deal : dealsList) {
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


    public static void cloneDeal(ArrayList<Deal> dealsList, Dealership dealership) {
        Scanner scanner = new Scanner(System.in);
        if (dealership.isDealershipCreated() && !dealsList.isEmpty()) {
            System.out.println("    __--Клонирование сделок--__");

            // Выводим список созданных сделок
            System.out.println("История сделок:");
            for (int i = 0; i < dealsList.size(); i++) {
                System.out.println((i + 1) + ". Сделка #" + dealsList.get(i).getTransaction_code());
            }

            int dealChoice;
            do {
                dealChoice = InpAndCheckedInt("Выберите номер сделки для клонирования: ");
                if (dealChoice > dealsList.size()) {
                    System.out.println("Неверная команда...");
                }
            } while (dealChoice < 1 || dealChoice > dealsList.size());

            try {
                // Клонирование сделки
                Deal clonedDeal = (Deal) dealsList.get(dealChoice - 1).clone();
                dealsList.add(clonedDeal);
                System.out.println("Клонирование завершено успешно!");
            } catch (CloneNotSupportedException e) {
                System.out.println("\nОшибка при клонировании сделки: " + e.getMessage() + "\n");
            }

        } else {
            System.out.println("История сделок пуста...\n");
        }
    }

}
