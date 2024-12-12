import java.util.Scanner;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = NotificationFactory.getInstance();

        NotificationFactory f = NotificationFactory.getInstance();
       
        System.out.println("What is the notification type? Is this SMS or EMAIL or PUSH notification?");
        Scanner inputScanner = new Scanner(System.in);
        String type = inputScanner.nextLine();
        System.out.println("Write the message: ");

        String msg = inputScanner.nextLine();

        Notification notification1 = notificationFactory.createNotification(type);
        notification1.notifyUser(msg);
        inputScanner.close();

        Notification n = f.createNotification("sms");
        n.notifyUser("sadsa sa");


        if(f == notificationFactory){
            System.out.println("Same");
        }else{
            System.out.println("Different");
        }




        
    }
    
}