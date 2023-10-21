package app_java;

public class Deal {
    private int deal_number;          // Номер сделки
    private String date;              // Дата сделки
    private  Emseller;         // Продавец
    private  buyer;          // Покупатель
    private  car_sold;            // Проданный автомобиль
    private int transaction_amount;  // Сумма сделки
    private  dealership;   // Автосалон


    public int getDeal_number() {
        return deal_number;
    }

    public void setDeal_number(int deal_number) {
        this.deal_number = deal_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public Car getCar_sold() {
        return car_sold;
    }

    public void setCar_sold(Car car_sold) {
        this.car_sold = car_sold;
    }

    public int getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }
}
