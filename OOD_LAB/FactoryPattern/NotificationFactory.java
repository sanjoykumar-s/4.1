public class NotificationFactory {
    public Notification getNotification(String notificationType) {
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
    
}
