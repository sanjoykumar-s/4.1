public class Manager extends AbstractProcess{
    
    public Manager(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println(message + " Manager.\n");
    }
}
