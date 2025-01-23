public abstract class AbstractProcess {

    public static int CASHIER = 1;
    public static int SENIOR_OFFICER = 2;
    public static int MANAGER = 3;

    public static int cur = 1;

    protected int level;

    protected AbstractProcess nextPerson;

    public void setNextPerson(AbstractProcess nextPerson) {
        this.nextPerson = nextPerson;
    }

    public void statusMessage (int level, String message) {
        if(this.level <= level) {
            write(message);
        }
        if(nextPerson!=null && this.level <= cur) {
            String to;
            if(cur == 1) {
                to = "Senior Officer";
                cur++;
            }
            else {
                to = "Manager";
                cur++;
            }
            System.out.println("Process is sending to " + to + "...");
            nextPerson.statusMessage(level, message);
        }
    }

    abstract protected void write(String message);

}

