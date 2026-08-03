import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueueManager {
    static Queue<String> names = new LinkedList<>();


    public static void main(String[] args) {

        /*prompt user to enter number of customers to add then start a loop to prompt user to enter customer names*/
        int namesToAdd = Integer.parseInt(IO.readln("Enter number of customers: "));
        if (namesToAdd <= 0) {
            IO.println("Invalid number of customers.");
        } else {
            for (int i = 1; i <= namesToAdd; i++) {
                String newName = IO.readln("Enter Customer Name: ");
                names.offer(newName);  /*add name to queue*/
            }
        }

        int choice;   /*create a menu*/
        do {
            IO.println("----- Menu -----");
            IO.println("1. Add Customer");
            IO.println("2. Serve Customer");
            IO.println("3. View Next Customer");
            IO.println("4. Search Customer");
            IO.println("5. Display All Customers");
            IO.println("6. Display Queue Statistics");
            IO.println("7. Exit");
            choice = Integer.parseInt(IO.readln("Enter your choice: "));

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    serve();
                    break;
                case 3:
                    viewNext();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    statistics();
                    break;
                case 7:
                    IO.println("Thank you. Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice. Please enter a valid number.");
                    break;

            }
        } while (choice != 7);

    }

    static void addCustomer() {
        String newCustomer = IO.readln("Enter new customer name: ");
        names.offer(newCustomer);
        IO.println("Customer added successfully");
    }


    static void serve() {
        if (names.isEmpty()) {
            IO.println("No customers in the queue.");
        } else {
            IO.println("Customer Served: " + names.poll());
        }
    }

    static void viewNext() {
        if (names.isEmpty()) {
            IO.println("Copy string literal text to the clipboard.");
        } else {
            IO.println("Next customer: " + names.peek());
        }
    }

   static void search(){
        String searchCustomer = IO.readln("Enter customer name: ");
            if (names.contains(searchCustomer)) {
                IO.println("Customer found in queue.");
            } else {
                IO.println("Customer not found.");
            }
        }

    static void display() {
        for (String name : names) {
            IO.println(name);
        }
    }

    static void statistics() {
        IO.println("Total number of customers: " + names.size());
        if (!names.isEmpty()) {
            IO.println("First name in queue: " + names.peek());
            String last = "";   /*iterate through the queue list to get the last name*/
            for (String n : names) {
                last = n;
            }
            IO.println("Last name in queue: " + last);
        }
        boolean isEmpty = (names.isEmpty()) ? true : false;
        IO.println("Is queue empty? " + isEmpty);
    }

}
