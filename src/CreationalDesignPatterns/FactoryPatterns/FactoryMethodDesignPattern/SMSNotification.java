package CreationalDesignPatterns.FactoryPatterns.FactoryMethodDesignPattern;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification...");
    }
}
