package BehaviouralDesignPatterns.ObserverDP;

public class StockTradingManager {
    private String stockName;
    private double currentPrice;
    private double notificationThreshold;

    private Publisher publisher;

    public StockTradingManager(String stockName, double currentPrice, double notificationThreshold, Publisher publisher) {
        this.stockName = stockName;
        this.currentPrice = currentPrice;
        this.notificationThreshold = notificationThreshold;
        this.publisher = publisher;
    }

    public void updateStockPrice(double newPrice) {
        currentPrice = newPrice;
        if(currentPrice > notificationThreshold){
            publisher.notifyObservers(this.stockName, this.currentPrice);
        }
    }
}
