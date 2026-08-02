import java.util.ArrayList;

public class BankTransactionManagementSystem {


    public static void main(String[] args) {
        ArrayList<Integer> accountNumbers = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<Double> balances = new ArrayList<>();
        ArrayList<String> accountTypes = new ArrayList<>();
        ArrayList<String> accountStatus = new ArrayList<>();

        // 1. Create 10 sample accounts
        accountNumbers.add(10001);
        customerNames.add("Ali");
        balances.add(2500.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");
        accountNumbers.add(10002);
        customerNames.add("Sara");
        balances.add(5000.0);
        accountTypes.add("Current");
        accountStatus.add("Active");
        accountNumbers.add(10003);
        customerNames.add("Ahmed");
        balances.add(1200.0);
        accountTypes.add("Savings");
        accountStatus.add("Suspended");
        accountNumbers.add(10004);
        customerNames.add("Noor");
        balances.add(800.0);
        accountTypes.add("Current");
        accountStatus.add("Active");
        accountNumbers.add(10005);
        customerNames.add("Omar");
        balances.add(3000.0);
        accountTypes.add("Savings");
        accountStatus.add("Closed");
        accountNumbers.add(10006);
        customerNames.add("Laila");
        balances.add(7000.0);
        accountTypes.add("Current");
        accountStatus.add("Active");
        accountNumbers.add(10007);
        customerNames.add("Hassan");
        balances.add(1500.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");
        accountNumbers.add(10008);
        customerNames.add("Fatima");
        balances.add(2000.0);
        accountTypes.add("Current");
        accountStatus.add("Active");
        accountNumbers.add(10009);
        customerNames.add("Khalid");
        balances.add(950.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");
        accountNumbers.add(10010);
        customerNames.add("Mona");
        balances.add(4000.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        // 2. Display Accounts
        IO.println("Customer Accounts:");
        for (int i = 0; i < accountNumbers.size(); i++) {
            IO.println("Account Index: " + i);
            IO.println("Account Number: " + accountNumbers.get(i));
            IO.println("Customer: " + customerNames.get(i));
            IO.println("Type: " + accountTypes.get(i));
            IO.println("Balance: " + balances.get(i));
            IO.println("Status: " + accountStatus.get(i));
        }

        // 3. Create New Account
        String newName = IO.readln("Enter Customer Name: ");
        double newBalance = Double.parseDouble(IO.readln("Enter Initial Balance: "));
        String newType = IO.readln("Enter Account Type (Savings/Current): ");
        if (newBalance < 0 || !(newType.equals("Savings") || newType.equals("Current"))) {
            IO.println("Invalid input. Account not created.");
        } else {
            int newAccNum = accountNumbers.get(accountNumbers.size() - 1) + 1;
            accountNumbers.add(newAccNum);
            customerNames.add(newName);
            balances.add(newBalance);
            accountTypes.add(newType);
            accountStatus.add("Active");
            IO.println("Account created successfully. Account Number: " + newAccNum);
        }

        // 4. Deposit Money
        int depAcc = Integer.parseInt(IO.readln("Enter Account Number for deposit: "));
        if (accountNumbers.contains(depAcc)) {
            int idx = accountNumbers.indexOf(depAcc);
            double depAmount = Double.parseDouble(IO.readln("Enter Deposit Amount: "));
            if (depAmount > 0) {
                balances.set(idx, balances.get(idx) + depAmount);
                IO.println("Deposit completed. New Balance: " + balances.get(idx));
            } else IO.println("Invalid deposit amount.");
        }

        // 5. Withdraw Money
        int withAcc = Integer.parseInt(IO.readln("Enter Account Number for withdrawal: "));
        if (accountNumbers.contains(withAcc)) {
            int idx = accountNumbers.indexOf(withAcc);
            double withAmount = Double.parseDouble(IO.readln("Enter Withdrawal Amount: "));
            if (withAmount > 0 && withAmount <= balances.get(idx)) {
                balances.set(idx, balances.get(idx) - withAmount);
                IO.println("Withdrawal successful. Remaining Balance: " + balances.get(idx));
            } else IO.println("Invalid withdrawal amount.");
        }

        // 6. Transfer Money
        int senderAcc = Integer.parseInt(IO.readln("Enter Sender Account Number: "));
        int receiverAcc = Integer.parseInt(IO.readln("Enter Receiver Account Number: "));
        double transferAmount = Double.parseDouble(IO.readln("Enter Transfer Amount: "));
        if (accountNumbers.contains(senderAcc) && accountNumbers.contains(receiverAcc) && transferAmount > 0) {
            int sIdx = accountNumbers.indexOf(senderAcc);
            int rIdx = accountNumbers.indexOf(receiverAcc);
            if (balances.get(sIdx) >= transferAmount) {
                balances.set(sIdx, balances.get(sIdx) - transferAmount);
                balances.set(rIdx, balances.get(rIdx) + transferAmount);
                IO.println("Transfer successful.");
            } else IO.println("Insufficient balance.");
        }

        // 7. Search Account
        String searchOption = IO.readln("Search by (Number/Name): ");
        if (searchOption.equalsIgnoreCase("Number")) {
            int searchNum = Integer.parseInt(IO.readln("Enter Account Number: "));
            if (accountNumbers.contains(searchNum)) {
                int idx = accountNumbers.indexOf(searchNum);
                IO.println("Account found: " + customerNames.get(idx) + " Balance: " + balances.get(idx) + " Status: " + accountStatus.get(idx));
            } else IO.println("Account not found.");
        } else {
            String searchName = IO.readln("Enter Customer Name: ");
            if (customerNames.contains(searchName)) {
                int idx = customerNames.indexOf(searchName);
                IO.println("Account found: Number " + accountNumbers.get(idx) + " Balance: " + balances.get(idx) + " Status: " + accountStatus.get(idx));
            } else IO.println("Account not found.");
        }

        // 8. Banking Statistics
        double totalBalance = 0, maxBalance = Double.MIN_VALUE, minBalance = Double.MAX_VALUE;
        for (double bal : balances) {
            totalBalance += bal;
            if (bal > maxBalance) maxBalance = bal;
            if (bal < minBalance) minBalance = bal;
        }
        double avgBalance = (double) totalBalance / balances.size();
        IO.println("Total Accounts: " + balances.size());
        IO.println("Total Balance: " + totalBalance);
        IO.println("Average Balance: " + avgBalance);
        IO.println("Highest Balance: " + maxBalance);
        IO.println("Lowest Balance: " + minBalance);

        // 9. Account Status Analysis
        int active = 0, suspended = 0, closed = 0;
        for (String status : accountStatus) {
            if (status.equals("Active")) active++;
            else if (status.equals("Suspended")) suspended++;
            else if (status.equals("Closed")) closed++;
        }
        IO.println("Active Accounts: " + active);
        IO.println("Suspended Accounts: " + suspended);
        IO.println("Closed Accounts: " + closed);

        // 10. Update Account Information
        int updIdx = Integer.parseInt(IO.readln("Enter Account Index to update: "));
        if (updIdx >= 0 && updIdx < accountNumbers.size()) {
            customerNames.set(updIdx, IO.readln("New Customer Name: "));
            accountTypes.set(updIdx, IO.readln("New Account Type: "));
            accountStatus.set(updIdx, IO.readln("New Account Status: "));
            IO.println("Account updated successfully.");
        } else IO.println("Invalid index.");

        // 11. Remove Account
        int remIdx = Integer.parseInt(IO.readln("Enter Account Index to remove: "));
        accountNumbers.remove(remIdx);
        customerNames.remove(remIdx);
        balances.remove(remIdx);
        accountTypes.remove(remIdx);
        accountStatus.remove(remIdx);
        IO.println("Account removed successfully.");

        // 12. Sorting Accounts
        ArrayList<Integer> sortedIndices = new ArrayList<>();
        for (int i = 0; i < accountNumbers.size(); i++) sortedIndices.add(i);

        // Sort by Balance Ascending
        sortedIndices.sort((a, b) -> Double.compare(balances.get(a), balances.get(b)));
        IO.println("Accounts sorted by Balance (Lowest to Highest):");
        for (int idx : sortedIndices) {
            IO.println(customerNames.get(idx) + " Balance: " + balances.get(idx));
        }

        // Sort by Balance Descending
        sortedIndices.sort((a, b) -> Double.compare(balances.get(b), balances.get(a)));
        IO.println("Accounts sorted by Balance (Highest to Lowest):");
        for (int idx : sortedIndices) {
            IO.println(customerNames.get(idx) + " Balance: " + balances.get(idx));
        }

        // Sort by Customer Name Alphabetically
        sortedIndices.sort((a, b) -> customerNames.get(a).compareTo(customerNames.get(b)));
        IO.println("Accounts sorted by Customer Name:");

    }
}
