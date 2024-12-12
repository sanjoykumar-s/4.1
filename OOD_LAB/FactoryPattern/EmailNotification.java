public class EmailNotification implements Notification{
    @Override
    public void notifyUser(String msg) {
        System.out.println("EmailNotification: " + msg);
    }
}
