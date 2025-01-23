public class Cashier extends AbstractProcess {
    
    public Cashier(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println(message + " Cashier");
    }
}
