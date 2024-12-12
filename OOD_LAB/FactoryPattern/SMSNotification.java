public class SMSNotification implements Notification{
    @Override
    public void notifyUser(String msg) {
        System.out.println("SMSNotification: " + msg);
    }
}
