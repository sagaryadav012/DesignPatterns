package BehaviouralDesignPatterns.ObserverDP;

public class AppService implements Observer{
    @Override
    public void send(String stockName, Double stockPrice) {
        String subject = "Price update for " + stockName;
        String message = ", New price is " + stockPrice;
        System.out.println("Sending notification to user through push notification : "+ subject + message);
    }
}
