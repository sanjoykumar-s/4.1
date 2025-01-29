public class SeniorOfficer extends AbstractProcess{
    
    public SeniorOfficer(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println(message + " Senior Officer.\n");
    }
}