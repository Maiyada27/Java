import java.util.ArrayList;

public class BankAccountSystem {
/*set variables names and types*/
    static ArrayList<String>accountNumbers= new ArrayList<>();
    static ArrayList<String>customerNames= new ArrayList<>();
    static ArrayList<Double>accountBalances= new ArrayList<>();

    public static void main(String[] args) {
        accountNumbers.add("87654321"); customerNames.add("Ali"); accountBalances.add(2400.12);
        accountNumbers.add("65433273"); customerNames.add("Asma"); accountBalances.add(670.00);
        accountNumbers.add("80836728"); customerNames.add("Sama"); accountBalances.add(1370.87);
        accountNumbers.add("87803475"); customerNames.add("Samira"); accountBalances.add(803.00);
        accountNumbers.add("87098362"); customerNames.add("Lama"); accountBalances.add(1962.54);

        Integer choice;
        do {                         /*start a loop so that it keeps looping while user did not choose to exit*/
            IO.println("1: Display all accounts");
            IO.println("2: Deposit money");
            IO.println("3: Withdraw money");
            IO.println("4: Check account balance");
            IO.println("5: Display account statistics");
            IO.println("6: Exit the program");
            choice= Integer.valueOf(IO.readln("Enter your choice: "));

            switch(choice){  /*call method for each case*/
                case 1:
                    displayAccounts();
                    break;
                case 2:
                    String account = IO.readln("Enter account number: ");
                    Double amount = Double.parseDouble(IO.readln("Enter amount: "));
                    depositMoney(account, amount);
                    break;
                case 3:
                    String account1 = IO.readln("Enter account number: ");
                    Double amount1 = Double.parseDouble(IO.readln("Enter amount: "));
                    withdrawMoney(account1,amount1);
                    break;
                case 4:
                    String account2 = IO.readln("Enter account number: ");
                    checkBalance(account2);
                    break;
                case 5:
                    calculateStatistics();
                    break;
                case 6:
                    IO.println("Thankyou. Goodbye");
                    break;

            }

        }while(choice != 6);

    }

    static void displayAccounts() {
        for (int i = 0; i <= accountNumbers.size() - 1; i++) {
            IO.println("Account number: " + accountNumbers.get(i) + ", Customer name: " + customerNames.get(i) + ", Account balance: " + accountBalances.get(i));
        }
    }

    static void depositMoney(String account, Double amount) {
        int index = accountNumbers.indexOf(account);
        Double newAmount = accountBalances.get(index) + amount;
        accountBalances.set(index, newAmount);
        IO.println("Deposit successful");
    }

    static void withdrawMoney(String account, Double amount){
        int index = accountNumbers.indexOf(account);
        if (amount > accountBalances.get(index)) {
            IO.println("Failed. Insufficient amount");
        }else {
            Double amount1 = accountBalances.get(index) - amount;
            accountBalances.set(index, amount1);
            IO.println("Successful");
        }
    }

    static void checkBalance(String account){
        int index = accountNumbers.indexOf(account);
        IO.println("Balance: " + accountBalances.get(index));
    }

    static void calculateStatistics() {
        Double total = 0.00;
        Double lowest = accountBalances.get(1);
        Double highest = accountBalances.get(1);
        Integer above100 = 0;
        for (int i = 0; i <= accountNumbers.size() - 1; i++) {
            total += accountBalances.get(i);
            if (accountBalances.get(i) < lowest) {
                lowest = accountBalances.get(i);
            }
            if (accountBalances.get(i) > highest) {
                highest = accountBalances.get(i);
            }
            if (accountBalances.get(i) > 100) {
                above100 += 1;
            }
        }
        IO.println("Total amount= " + total + ", Lowest balance= " + lowest + ", Highest balance= " + highest + ", Number of acounts with balance above 100= " + above100);
    }
}
