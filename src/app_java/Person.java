package app_java;

public abstract class Person {
    private String first_name; // Имя человека
    private String last_name; // Фамилия человека

    public Person(){};
    public Person(String first_name, String last_name){
        setFirstName(first_name);
        setLastName(last_name);
    }

    public String getFirstName(){ // Метод получения имени человека
        return first_name;
    }
    public String getLastName() {// Метод получения фамилии человека
        return last_name;
    }
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
}
