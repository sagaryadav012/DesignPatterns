package CreationalDesignPatterns.FactoryPatterns.FactoryMethodDesignPattern;

public class NotificationFactory {
    public Notification createNotification(NotificationType notificationType){
//        if(notificationType.equals(NotificationType.SMS)){
//            return new SMSNotification();
//        }
//        else if(notificationType.equals(NotificationType.EMAIL)){
//            return new EmailNotification();
//        }
//        else if(notificationType.equals(NotificationType.IMPORTANT)){
//            return new PushNotification();
//        }
//        else{
//            throw new UnsupportedOperationException("This notification not valid");
//        }
        switch (notificationType){
            case SMS : return new SMSNotification();
            case EMAIL : return new EmailNotification();
            case IMPORTANT : return new PushNotification();
            default: throw new UnsupportedOperationException("This notification not valid");
        }
    }
}
