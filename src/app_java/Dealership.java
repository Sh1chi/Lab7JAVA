package app_java;

public class Dealership {
    private static final int MAX_EMPLOYEE = 100;
    private static final int MAX_CARS = 100;

    private String name; // Название автосалона
    private String address; // Адрес автосалона
    private Employee[] employees = new Employee[MAX_EMPLOYEE]; // Список сотрудников
    private Car[] cars = new Car[MAX_CARS]; // Список имеющихся автомобилей

    // Конструктор класса
    public Dealership(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Метод для добавления сотрудника в массив employees
    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    // Метод для добавления автомобиля в массив cars
    public void addCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                break;
            }
        }
    }

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

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
