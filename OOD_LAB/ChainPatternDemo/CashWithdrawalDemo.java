import java.util.Scanner;

public class CashWithdrawalDemo {
    
    private static AbstractProcess getChainOfProcess() {
        AbstractProcess cashier = new Cashier(AbstractProcess.CASHIER);
        AbstractProcess seniorOfficer = new SeniorOfficer(AbstractProcess.SENIOR_OFFICER);
        AbstractProcess manager = new Manager(AbstractProcess.MANAGER);

        cashier.setNextPerson(seniorOfficer);
        seniorOfficer.setNextPerson(manager);

        return cashier;
    }

    public static void main(String[] args) {
        AbstractProcess processChain = getChainOfProcess();

            Scanner sc=new Scanner(System.in);
            int amount = sc.nextInt();
            sc.close();
            if(amount < 10000) {
                processChain.statusMessage(AbstractProcess.CASHIER, "This Withdraw request is processed by");
            }
            else if (amount > 10000 && amount < 1000000) {
                processChain.statusMessage(AbstractProcess.SENIOR_OFFICER, "This Withdraw request is processed by");
            }
            else {
                processChain.statusMessage(AbstractProcess.MANAGER, "This Withdraw request is processed by");
            }
    }

}
