package app_java;

public abstract class Person {
    protected String first_name; // Имя человека
    protected String last_name; // Фамилия человека

    // Конструктор без параметров
    public Person(){
        this.first_name = "";
        this.last_name = "";
    };

    //Конструтор с параметрами
    public Person(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    // Метод получения имени человека
    public String getFirstName(){
        return first_name;
    }

    // Метод получения фамилии человека
    public String getLastName() {
        return last_name;
    }

    // Метод установки имени человека
    // Перегрузка метода setFirstName для добавления отчества
    public void setFirstName(String first_name, String patronymic) {
        this.first_name = first_name + " " + patronymic;
    }

    // Метод установки фамилии человека
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
}
