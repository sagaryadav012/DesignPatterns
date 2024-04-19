package CreationalDesignPatterns.FactoryPatterns.FactoryMethodDesignPattern;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Pushing important notification...");
    }
}
