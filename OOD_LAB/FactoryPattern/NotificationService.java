import java.util.Scanner;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        System.out.println("What is the notification type? Is this SMS or EMAIL or PUSH notification?");
        Scanner inputScanner = new Scanner(System.in);
        String type = inputScanner.nextLine();
        System.out.println("Write the message: ");
        String msg = inputScanner.nextLine();
        Notification notification1 = notificationFactory.getNotification(type);
        notification1.notifyUser(msg);
        inputScanner.close();
        
    }
    
}
