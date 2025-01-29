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
            boolean shouldContinue = false;
            do {
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the amount to withdraw: ");
                int amount = sc.nextInt();
                System.out.println("Please wait... Processing your request...\n");
                
                if(amount < 10000) {
                    processChain.statusMessage(AbstractProcess.CASHIER, amount);
                }
                else if (amount < 1000000) {
                    processChain.statusMessage(AbstractProcess.SENIOR_OFFICER, amount);
                }
                else {
                    processChain.statusMessage(AbstractProcess.MANAGER, amount);
                }

                System.out.println("Do you want to withdraw more amount? (yes/no): ");
                String response = sc.next();
                if(response.equalsIgnoreCase("yes")) {
                    shouldContinue = true;
                }
                else {
                    shouldContinue = false;
                    sc.close();
                }
            }while(shouldContinue);
    }

}
