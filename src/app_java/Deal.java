package app_java;

import java.util.Scanner;

import static app_java.Func.confirmAction;

public class Deal {
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

    private static int generateDealNumber() {
        return deal_number++;
    }

    // Метод для получения заработка автосалона по текущей сделке
    public int getProfit() {
        return CarSaleCalculator.calculateProfit(transaction_amount);
    }

    public int getDeal_number() {
        return transaction_code;
    }

    public void setDeal_number(int deal_number) {
        this.transaction_code = deal_number;
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
    public void inpDeal(Dealership dealership, Deal[] dealsArray) {
        Scanner scanner = new Scanner(System.in);
        // Проверка наличия созданного автосалона
        if (!dealership.isDealershipCreated()) {
            System.out.println("Ошибка: 'Автосалон отсутствует'!\nПожалуйста, создайте автосалон перед оформлением сделки.");
            return;
        }

        // Проверка наличия сотрудников
        if (Dealership.getNumEmployees() == 0) {
            System.out.println("Ошибка: 'Сотрудники отсутствуют'!\nПожалуйста, добавьте сотрудников перед оформлением сделки.");
            return;
        }

        // Проверка наличия автомобилей
        if (Dealership.getNumCars() == 0) {
            System.out.println("Ошибка: 'Автомобили отсутствуют'!\nПожалуйста, добавьте автомобили перед оформлением сделки.");
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
            System.out.print("Выберите номер продавца из списка: ");
            employeeChoice = scanner.nextInt();
            if (employeeChoice < 1 || employeeChoice > Dealership.getNumEmployees()) {
                System.out.println("Неверная команда...");
            }
        } while (employeeChoice < 1 || employeeChoice > Dealership.getNumEmployees());

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
            if (carChoice < 1 || carChoice > Dealership.getNumCars()) {
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
    public static void printProfits(Deal[] dealsArray) {
        System.out.println();
        System.out.println("    __-- Заработок автосалона --__");

        for (int i = 0; i < deal_number; i++) {
            Deal deal = dealsArray[i];
            if (deal != null) {
                int profit = CarSaleCalculator.calculateProfit(deal.getTransaction_amount());
                System.out.println("Cделка #" + deal.getDeal_number() + ": " + profit);
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
                System.out.println("Cделка #" + deal.getDeal_number());
                System.out.println("Дата сделки: " + deal.getDate());
                System.out.println("Продавец: " + deal.getEmployee().getFirstName() + " " + deal.getEmployee().getLastName());
                System.out.println("Покупатель: " + deal.getCustomer().getFirstName() + " " + deal.getCustomer().getLastName());
                System.out.println("Проданный автомобиль: " + deal.getCar().getBrand_model());
                System.out.println("Сумма сделки: " + deal.getTransaction_amount());
                System.out.println();
            }
        }
    }

}
