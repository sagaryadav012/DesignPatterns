package CreationalDesignPatterns.FactoryPatterns.FactoryMethodDesignPattern;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification...");
    }
}
