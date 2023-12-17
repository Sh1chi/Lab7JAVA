package app_java;

public class ShablonTestTransport<T> {
    private String model;
    private int year;
    private T additionalInfo; // Дополнительная информация о транспортном средстве

    public ShablonTestTransport(String model, int year, T additionalInfo) {
        this.model = model;
        this.year = year;
        this.additionalInfo = additionalInfo;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public T getAdditionalInfo() {
        return additionalInfo;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAdditionalInfo(T additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
