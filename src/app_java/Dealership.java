package app_java;

import java.util.Scanner;

import static app_java.Func.*;

public class Dealership {
    private static final int MAX_EMPLOYEE = 100; // max сотрудников
    private static final int MAX_CARS = 100; // max авто
    private static int numEmployees; // Статическая переменная для количества сотрудников
    private static int numCars; // Статическая переменная для количества автомобилей

    private String name; // Название автосалона
    private String address; // Адрес автосалона
    private Employee[] employees = new Employee[MAX_EMPLOYEE]; // Список сотрудников
    private Car[] cars = new Car[MAX_CARS]; // Список имеющихся автомобилей

    // Конструктор без параметров
    public Dealership() {
        this.name = "";
        this.address = "";
    }

    // Конструктор с параметрами
    public Dealership(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static int getNumEmployees(){return numEmployees;}

    public static int getNumCars(){return numCars;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Car[] getCars() {
        return cars;
    }

    public boolean isDealershipCreated() {
        return (name != null && !name.isEmpty()) || (address != null && !address.isEmpty());
    }

    // Метод ввода автосалона
    public void inputDealership() {
        if (isDealershipCreated()) {
            System.out.println("Автосалон уже существует.");
            if (!confirmAction("При пересоздании все предыдущие данные будут удалены.\nХотите продолжить? (Да/Нет)")) {
                return;
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("    __-- Создание автосалона --__");

        do {
            String redColor = "\u001B[31m";
            String resetColor = "\u001B[0m";

            try {
                // Ввод данных об автосалоне
                System.out.print("Введите название автосалона: ");
                name = scanner.nextLine();
                System.out.print("Введите адрес автосалона: ");
                address = scanner.nextLine();

                if (!isDealershipCreated()){
                    throw new IllegalArgumentException("Некорректные данные");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            }
        } while (true);

        // Ввод количества сотрудников и создание массива сотрудников
        numEmployees = InpAndCheckedInt("Введите количество сотрудников: ");
        if (numEmployees != 0) {
            System.out.println();
            System.out.println("  -- Ввод данных о сотрудниках --");
            for (int i = 0; i < numEmployees; ++i) {
                System.out.println("Сотрудник #" + (i + 1) + ":");
                employees[i] = new Employee();
                employees[i].inputEmployee();
                System.out.println();
            }
        }

        // Ввод количества автомобилей и создание массива автомобилей
        numCars = InpAndCheckedInt("Введите количество автомобилей: ");
        if (numCars != 0) {
            System.out.println();
            System.out.println("  -- Ввод данных об автомобилях --");
            for (int i = 0; i < numCars; ++i) {
                System.out.println("Автомобиль #" + (i + 1) + ":");
                cars[i] = new Car();
                cars[i].inputCar();
                System.out.println();
            }
        }

    }

    // Методы добавления сотрудников и авто
    public void addEmployeesToDealership() {
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        try {
            if (!isDealershipCreated()) {
                throw new IllegalStateException("Автосалон отсутствует. Пожалуйста, создайте автосалон перед добавлением сотрудников");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }

            System.out.println("  -- Добавление новых сотрудников в автосалон --");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите количество новых сотрудников: ");
            int numNewEmployees = scanner.nextInt();

            int newTotalEmployees = numEmployees + numNewEmployees;

            // Получаем массив существующих сотрудников в автосалоне
            Employee[] oldEmployees = employees;

            // Создаем временный массив, куда скопируем существующих сотрудников
            Employee[] tempEmployees = new Employee[newTotalEmployees];

            // Копируем существующих сотрудников во временный массив
            System.arraycopy(oldEmployees, 0, tempEmployees, 0, numEmployees);

            System.out.println();
            // Вводим и добавляем новых сотрудников во временный массив
            for (int i = numEmployees; i < newTotalEmployees; ++i) {
                // Ввод данных о сотруднике
                System.out.println("Сотрудник #" + (i + 1));
                Employee newEmployee = new Employee();  // Assuming Employee has a default constructor
                newEmployee.inputEmployee();  // Assuming there's an inputEmployee method in the Employee class
                System.out.println();

                // Добавляем нового сотрудника во временный массив
                tempEmployees[i] = newEmployee;
            }

            // Обновляем количество сотрудников в автосалоне
            numEmployees = newTotalEmployees;

            // Обновляем массив сотрудников автосалона на новый временный массив
            employees = tempEmployees;

    }

    public void addCarsToDealership() {
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        try {
            if (!isDealershipCreated()) {
                throw new IllegalStateException("Автосалон отсутствует. Пожалуйста, создайте автосалон перед добавлением автомобилей");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }

        System.out.println("  --  Добавление новых автомобилей в автосалон --");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество новых автомобилей: ");
        int numNewCars = scanner.nextInt();

        int newTotalCars = numCars + numNewCars;

        // Получаем массив существующих автомобилей в автосалоне
        Car[] oldCars = cars;

        // Создаем временный массив, куда скопируем существующие автомобили
        Car[] tempCars = new Car[newTotalCars];

        // Копируем существующие автомобили во временный массив
        System.arraycopy(oldCars, 0, tempCars, 0, numCars);


        System.out.println();
        // Вводим и добавляем новые автомобили во временный массив
        for (int i = numCars; i < newTotalCars; ++i) {
            // Ввод данных об автомобиле
            System.out.println("Автомобиль #" + (i + 1));
            Car newCar = new Car();  // Assuming Car has a default constructor
            newCar.inputCar();  // Assuming there's an inputCar method in the Car class
            System.out.println();

            // Добавляем новый автомобиль во временный массив
            tempCars[i] = newCar;
        }

        // Обновляем количество автомобилей в автосалоне
        numCars = newTotalCars;

        // Обновляем массив автомобилей автосалона на новый временный массив
        cars = tempCars;
    }

    // Методы удаления сотрудников и авто
    public void removeEmployeeFromDealership() {
        System.out.print("  -- Удаление сотрудника из базы --\n");

        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        try {
            if (numEmployees == 0) {
                throw new IllegalStateException("В дилерском центре отсутствуют сотрудники");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }

        outEmployeesChoice();

        Scanner scanner = new Scanner(System.in);

        int employeeIndex;
        do {
            employeeIndex = InpAndCheckedInt("Введите номер сотрудника, которого вы хотите удалить: ");

            if (employeeIndex < 1 || employeeIndex > numEmployees) {
                System.out.println("Ошибка: 'Недопустимый номер сотрудника'!");
            }
        } while (employeeIndex > numEmployees);

        // Удаляем выбранного сотрудника путем сдвига оставшихся элементов
        for (int i = employeeIndex - 1; i < numEmployees - 1; ++i) {
            employees[i] = employees[i + 1];
        }

        // Обнуляем значение последнего элемента
        employees[numEmployees - 1] = null;

        // Уменьшаем общее количество сотрудников в автосалоне
        numEmployees--;

        System.out.println("Сотрудник удален из автосалона.");
    }

    public void removeCarFromDealership() {
        System.out.print("  -- Удаление авто из базы --\n");

        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        try {
            if (numCars == 0) {
                throw new IllegalStateException("В дилерском центре отсутствуют автомобили");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
            return;
        }

        outCarsChoice();

        Scanner scanner = new Scanner(System.in);

        int carIndex;
        do {
            carIndex = InpAndCheckedInt("Введите номер автомобиля, который вы хотите удалить: ");

            if (carIndex < 1 || carIndex > numCars) {
                System.out.println("Ошибка: 'Недопустимый номер автомобиля'!");
            }
        } while (carIndex > numCars);

        // Удаляем выбранный автомобиль путем сдвига оставшихся элементов
        for (int i = carIndex - 1; i < numCars - 1; ++i) {
            cars[i] = cars[i + 1];
        }

        // Обнуляем значение последнего элемента
        cars[numCars - 1] = null;

        // Уменьшаем общее количество автомобилей в автосалоне
        numCars--;

        System.out.println("Автомобиль удален из автосалона.");
    }

    // Методы вывода различной информации об автосалоне
    public void outAllInfoDealership(){
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        try {
            System.out.println();
            if (isDealershipCreated()) {
                System.out.println("    __-- Автосалон " + name + " --__");
                System.out.println("по адресу: " + address);
                System.out.println();
                outEmployeeDealership();
                outCarDealership();
            } else {
                throw new IllegalStateException("Отсутствует название или адрес автосалона. Информация недоступна");
            }
        } catch (IllegalStateException e) {
            System.out.println(redColor + "Ошибка: '" + e.getMessage() + "'!" + resetColor); // Красный цвет текста
        }
    }

    public void outEmployeeDealership() {
        if (numEmployees == 0) {
            System.out.println("    __-- Сотрудники автосалона --__");
            System.out.println("В дилерском центре отсутствуют сотрудники.\n");
        } else {
            System.out.println("    __-- Сотрудники автосалона " + name + " --__");
            for (int i = 0; i < numEmployees; ++i) {
                System.out.println("Сотрудник #" + (i + 1) + ":");
                employees[i].outEmployee();
                System.out.println();
            }
        }
    }

    public void outCarDealership(){
        if (numCars == 0) {
            System.out.println("    __-- Автомобили автосалона --__");
            System.out.println("В дилерском центре отсутствуют автомобили.\n");
        } else {
            System.out.println("    __-- Автомобили автосалона " + name + " --__");
            for (int i = 0; i < numCars; ++i) {
                System.out.println("Автомобиль #" + (i + 1) + ":");
                cars[i].outCar();
                System.out.println();
            }
        }
        System.out.println();
    }

    // Методы вывода выпадающего списка выбора
    public void outCarsChoice() {
        System.out.println("Автомобили в наличии:");
        for (int i = 0; i < numCars; i++) {
            System.out.println("    " + (i + 1) + ") " + cars[i].getBrand_model()+ " - " + cars[i].getPrice());
        }
    }

    public void outEmployeesChoice() {
        System.out.println("Список продавцов:");
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("    " + (i + 1) + ") " + employees[i].getFirstName() + " " + employees[i].getLastName() + " - " + employees[i].getPosition());
        }
    }

}