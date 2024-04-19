package CreationalDesignPatterns.FactoryPatterns.FactoryMethodDesignPattern;

public class Client {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(NotificationType.IMPORTANT);

        notification.notifyUser();
    }
}

/*
  There is client, client has to notify or send notification to users. There are different type of notifications like
  sms, email and other important notification. So client asks help from notification factory and client gives notification type
  to notification factory. Notification factory delegates object creation to it's factory method(inside interface).
  Based on the notification type the respective concrete classes would be called at run time.

  or another example
  A user want a phone he went to factory asked phn, factory can create different kind of phones, Factory creates
  phone on user requirement.



 Factory Method Design Pattern :
 -> Factory Method DP defines an interface for creating objects, but it let subclasses decides which class to instantiate.
 -> Since this pattern talk about instantiation object, it comes under Object creational Design Pattern.
 -> It delegates object creation to subclasses.

 When we use factory method DP :
 -> Adding new feature to current codebase becomes headache or when we have to create the object depends on some condition or input.

 For example client wants to send notifications to user. Notification could be different types, it could be SMS, EMAIL or PUSH notification.
 Depends on the notification type we need to create object of notification.

 We can write code like this.
 class SendNotification{
    public void send(NotificationType type){
        if(type.equals(NotificationType.SMS)){
            // write code to send SMS notification
        }
        else if(type.equals(NotificationType.PUSH)){
            // write code to send PUSH notification
        }
        else if(type.equals(NotificationType.EMAIL)){
            // write code to send EMAIL notification
        }
    }
  }
-> But the above code violates SRP and OCP principles.
-> Send method has to send notification, But it is doing more than that, It is checking notification type and sending notification.
   But if we have to change this class, It should have only one reason to change.(SRP violates here)
-> OCP : If we add new notification type, we have to modify existing code.


Here factory method comes into picture, It defines common interface and subclasses will implement it.

Notification interface :
public interface Notification {
    public void notifyUser();
}

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification...");
    }
}

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Pushing important notification...");
    }
}

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification...");
    }
}


public class NotificationFactory {
    public Notification createNotification(NotificationType notificationType){
        switch (notificationType){
            case SMS : return new SMSNotification();
            case EMAIL : return new EmailNotification();
            case IMPORTANT : return new PushNotification();
            default: throw new UnsupportedOperationException("This notification not valid");
        }
    }
}

Here notification factory gives notification object based input(Notification Type)

Client Code :
public class Client {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(NotificationType.IMPORTANT);

        notification.notifyUser();
    }
}

Why it matters :
Flexibility: Easily add new feature without modifying existing code.
Decoupling: Break free from tight dependencies, enhancing maintainability.
Simplicity: Keep client code oblivious to product creation details, promoting clean architecture.

 */

