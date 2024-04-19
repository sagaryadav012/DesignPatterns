package BehaviouralDesignPatterns.ObserverDP;

public class Main {
    public static void main(String[] args) {
        // list of observers
        AppService appService = new AppService();
        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();

        // Register all observers with publisher
        Publisher publisher = new Publisher();
        publisher.addObserver(appService);
        publisher.addObserver(emailService);
        publisher.addObserver(smsService);

        String stockName = "MRF";
        double initialPrice = 24654.68;
        double thresholdPrice = 31000.00;

        StockTradingManager stockTradingManager = new StockTradingManager(stockName, initialPrice, thresholdPrice, publisher);

        stockTradingManager.updateStockPrice(31000.10);

    }
}
/*
Observer DP :
-> Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

When to use?
-> When multiple objects observing an object, if any event occurs to object then the objects should get notified.

Example :
You are developing a stock trading platform where users need to be notified
whenever the price of a particular stock crosses a certain threshold.
These notifications should be sent through various channels such as email, SMS, and mobile app notifications.
To achieve this, you want to implement the Observer pattern,
allowing users to subscribe to stock price updates and receive notifications through multiple channels.


-> Here users get notified when stock price goes beyond threshold price and users should get notified by different notification channels.
-> So here observers are Notification channels(AppService, SMSService, EmailService), These channels should get notified and
   will send notification to all users.
-> Observers will go to publisher and register themselves to get notified.
-> When stock price goes beyond threshold price, publisher will notify all observers that are registered earlier.
-> There could be multiple observers so make them implement common interface.
-> As well There could be multiple publishers, so make them implement common interface.
 */
