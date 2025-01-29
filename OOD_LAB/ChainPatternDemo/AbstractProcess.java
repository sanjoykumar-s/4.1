public abstract class AbstractProcess {

    public static int CASHIER = 1;
    public static int SENIOR_OFFICER = 2;
    public static int MANAGER = 3;

    protected int level;

    protected AbstractProcess nextPerson;

    public void setNextPerson(AbstractProcess nextPerson) {
        this.nextPerson = nextPerson;
    }

    public void statusMessage (int level, int amount) {
        if(level - this.level < 2) {
            write("This Withdraw request of amount: " + Integer.toString(amount) + " is processed by");
        }
        if(nextPerson!=null && this.level < level) {
            String to;
            if(this.level == 1) {
                to = "Senior Officer";
            }
            else{
                to = "Manager";
            }
            System.out.println("Please Wait... Process is sending to " + to + "...\n");
            nextPerson.statusMessage(level, amount);
        }
        else {
            System.out.println("Amount: " + Integer.toString(amount) + " is Paid.\n");
        }
    }

    abstract protected void write(String message);

}

