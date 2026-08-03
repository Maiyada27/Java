
import java.util.LinkedList;
import java.util.Queue;

public class TicketQueueManager {
    static Queue<String> customers = new LinkedList<>();

    public static void main(String[] args) {

                int numberOfCustomers = Integer.parseInt(IO.readln("Enter number of customers: "));
                if (numberOfCustomers <= 0) {
                    IO.println("Invalid number of customers.");
                } else {
                    for (int i = 1; i <= numberOfCustomers; i++) {
                        String name = IO.readln("Enter customer name: ");
                        customers.add(name); // add to queue
                    }
                }

                int choice;
                do {
                    IO.println("\n===== Ticket Queue Menu =====");
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
                            serveCustomer();
                            break;
                        case 3:
                            viewNextCustomer();
                            break;
                        case 4:
                            searchCustomer();
                            break;
                        case 5:
                            displayAllCustomers();
                            break;
                        case 6:
                            displayStatistics();
                            break;
                        case 7:
                            IO.println("Exiting program. Goodbye!");
                            break;
                        default:
                            IO.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (choice != 7);
            }

            static void addCustomer() {
                String name = IO.readln("Enter customer name: ");
                customers.add(name);
                IO.println("Customer added successfully.");
            }

            static void serveCustomer() {
                if (customers.isEmpty()) {
                    IO.println("Queue is empty.");
                } else {
                    String served = customers.remove(); // remove first
                    IO.println("Served customer: " + served);
                }
            }

            static void viewNextCustomer() {
                if (customers.isEmpty()) {
                    IO.println("Queue is empty.");
                } else {
                    IO.println("Next customer: " + customers.element());
                }}

    static void searchCustomer() {
        String name = IO.readln("Enter customer name to search: ");
        if (customers.contains(name)) {
            IO.println("Customer found in queue.");
        } else {
            IO.println("Customer not found.");
        }
    }

    static void displayAllCustomers() {
        if (customers.isEmpty()) {
            IO.println("Queue is empty.");
        } else {
            IO.println("All customers in the queue:");
            for (String customer : customers) {
                IO.println(customer);
            }
        }
    }

    static void displayStatistics() {
        IO.println("\n===== Queue Statistics =====");
        IO.println("Total customers: " + customers.size());
        if (!customers.isEmpty()) {
            IO.println("First customer: " + customers.peek());
            // Find last customer by iterating
            String last = "";
            for (String c : customers) {
                last = c;
            }
            IO.println("Last customer: " + last);
        }
        IO.println("Is queue empty? " + customers.isEmpty());
    }
}


