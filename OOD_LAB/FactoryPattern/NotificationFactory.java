public class NotificationFactory {
    

    public static NotificationFactory instance = new NotificationFactory();

    private NotificationFactory(){}
    
    public Notification createNotification(String notificationType) {
       
        if(notificationType.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        else if(notificationType.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        else if(notificationType.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null;
    }

    public static NotificationFactory getInstance() {
        return instance;
    }
    
}
