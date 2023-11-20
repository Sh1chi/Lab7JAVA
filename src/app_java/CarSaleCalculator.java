package app_java;

public class CarSaleCalculator {
    private static int totalProfit = 0;

    // Метод для вычисления заработка автосалона по текущей сделке
    public static int calculateProfit(int transactionAmount) {
        double markupPercentage = 0.05;
        double profit = transactionAmount * markupPercentage;

        return (int) profit;
    }

    // Метод для увеличения общего заработка автосалона
    public static void addToTotalProfit(int transactionAmount) {
        totalProfit += calculateProfit(transactionAmount);
    }

    // Метод для получения общего заработка автосалона
    public static int getTotalProfit() {
        return totalProfit;
    }

    // Метод для установки нового значения общего заработка автосалона
    public static void setTotalProfit(int newTotalProfit) {
        totalProfit = newTotalProfit;
    }
}
