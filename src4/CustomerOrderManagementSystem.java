import java.util.ArrayList;
import java.util.Arrays;

public class CustomerOrderManagementSystem {

    static ArrayList<Integer> orderIds = new ArrayList<>();
    static ArrayList<String> customerNames = new ArrayList<>();
    static ArrayList<String> productNames = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<String> orderStatus = new ArrayList<>();

    public static void main(String[] args) {
        // Add 15 sample orders
        orderIds.add(1001);
        customerNames.add("Ali");
        productNames.add("Laptop");
        quantities.add(2);
        prices.add(750.0);
        orderStatus.add("Pending");
        orderIds.add(1002);
        customerNames.add("Sara");
        productNames.add("Phone");
        quantities.add(1);
        prices.add(1200.0);
        orderStatus.add("Completed");
        orderIds.add(1003);
        customerNames.add("Ahmed");
        productNames.add("Tablet");
        quantities.add(3);
        prices.add(500.0);
        orderStatus.add("Cancelled");
        orderIds.add(1004);
        customerNames.add("Noor");
        productNames.add("Camera");
        quantities.add(2);
        prices.add(1500.0);
        orderStatus.add("Pending");
        orderIds.add(1005);
        customerNames.add("Omar");
        productNames.add("Headphones");
        quantities.add(5);
        prices.add(200.0);
        orderStatus.add("Completed");
        orderIds.add(1006);
        customerNames.add("Laila");
        productNames.add("Monitor");
        quantities.add(1);
        prices.add(800.0);
        orderStatus.add("Pending");
        orderIds.add(1007);
        customerNames.add("Hassan");
        productNames.add("Keyboard");
        quantities.add(4);
        prices.add(100.0);
        orderStatus.add("Completed");
        orderIds.add(1008);
        customerNames.add("Fatima");
        productNames.add("Mouse");
        quantities.add(6);
        prices.add(50.0);
        orderStatus.add("Pending");
        orderIds.add(1009);
        customerNames.add("Khalid");
        productNames.add("Printer");
        quantities.add(1);
        prices.add(600.0);
        orderStatus.add("Completed");
        orderIds.add(1010);
        customerNames.add("Mona");
        productNames.add("TV");
        quantities.add(2);
        prices.add(2000.0);
        orderStatus.add("Pending");
        orderIds.add(1011);
        customerNames.add("Zara");
        productNames.add("Speaker");
        quantities.add(3);
        prices.add(300.0);
        orderStatus.add("Completed");
        orderIds.add(1012);
        customerNames.add("Yusuf");
        productNames.add("Router");
        quantities.add(2);
        prices.add(150.0);
        orderStatus.add("Cancelled");
        orderIds.add(1013);
        customerNames.add("Salim");
        productNames.add("SSD");
        quantities.add(5);
        prices.add(120.0);
        orderStatus.add("Pending");
        orderIds.add(1014);
        customerNames.add("Aisha");
        productNames.add("Smartwatch");
        quantities.add(1);
        prices.add(900.0);
        orderStatus.add("Completed");
        orderIds.add(1015);
        customerNames.add("Bilal");
        productNames.add("Drone");
        quantities.add(2);
        prices.add(2500.0);
        orderStatus.add("Pending");

        // 2. Display Orders
        IO.println("Order List:");
        for (int i = 0; i < orderIds.size(); i++) {
            double total = quantities.get(i) * prices.get(i);
            IO.println("Order Index: " + i);
            IO.println("Order ID: " + orderIds.get(i));
            IO.println("Customer: " + customerNames.get(i));
            IO.println("Product: " + productNames.get(i));
            IO.println("Quantity: " + quantities.get(i));
            IO.println("Price: " + prices.get(i));
            IO.println("Total: " + total);
            IO.println("Status: " + orderStatus.get(i));
        }

        // 3. Add New Order
        String newCustomer = IO.readln("Enter Customer Name: ");
        String newProduct = IO.readln("Enter Product Name: ");
        int newQuantity = Integer.parseInt(IO.readln("Enter Quantity: "));
        double newPrice = Double.parseDouble(IO.readln("Enter Price: "));
        String newStatus = IO.readln("Enter Status (Pending/Completed/Cancelled): ");

        if (newQuantity <= 0 || newPrice < 0 ||
                !(newStatus.equals("Pending") || newStatus.equals("Completed") || newStatus.equals("Cancelled"))) {
            IO.println("Invalid input. Order not added.");
        } else {
            int newOrderId = orderIds.get(orderIds.size() - 1) + 1;
            orderIds.add(newOrderId);
            customerNames.add(newCustomer);
            productNames.add(newProduct);
            quantities.add(newQuantity);
            prices.add(newPrice);
            orderStatus.add(newStatus);
            IO.println("Order added successfully. Total Orders: " + orderIds.size());
        }

        // 4. Order Statistics
        double totalSales = 0, maxOrder = Double.MIN_VALUE, minOrder = Double.MAX_VALUE;
        for (int i = 0; i < orderIds.size(); i++) {
            double total = quantities.get(i) * prices.get(i);
            totalSales += total;
            if (total > maxOrder) maxOrder = total;
            if (total < minOrder) minOrder = total;
        }
        double avgOrder = (double) totalSales / orderIds.size();
        IO.println("Total Orders: " + orderIds.size());
        IO.println("Total Sales: " + totalSales);
        IO.println("Average Order: " + avgOrder);
        IO.println("Highest Order: " + maxOrder);
        IO.println("Lowest Order: " + minOrder);

        // 5. Order Status Analysis
        int pending = 0, completed = 0, cancelled = 0;
        for (String status : orderStatus) {
            if (status.equals("Pending")) {
                pending += 1;
            } else if (status.equals("Completed")) {
                completed += 1;
            } else if (status.equals("Cancelled")) {
                cancelled += 1;
            }
        }
        IO.println("Pending Orders: " + pending);
        IO.println("Completed Orders: " + completed);
        IO.println("Cancelled Orders: " + cancelled);

        // 6. Search Order
        String searchOption = IO.readln("Search by (ID/Name): ");
        if (searchOption.equalsIgnoreCase("ID")) {
            int searchId = Integer.parseInt(IO.readln("Enter Order ID: "));
            if (orderIds.contains(searchId)) {
                int idx = orderIds.indexOf(searchId);
                IO.println("Order found: " + customerNames.get(idx) + " - " + productNames.get(idx) +
                        " Total: " + (quantities.get(idx) * prices.get(idx)) +
                        " Status: " + orderStatus.get(idx));
            } else IO.println("Order not found.");
        } else {
            String searchName = IO.readln("Enter Customer Name: ");
            if (customerNames.contains(searchName)) {
                int idx = customerNames.indexOf(searchName);
                IO.println("Order found: ID " + orderIds.get(idx) + " Product: " + productNames.get(idx) +
                        " Total: " + (quantities.get(idx) * prices.get(idx)) +
                        " Status: " + orderStatus.get(idx));
            } else IO.println("Order not found.");
        }

        // 7. Update Order
        int updateIndex = Integer.parseInt(IO.readln("Enter Order Index to update: "));
        if (updateIndex >= 0 && updateIndex < orderIds.size()) {
            customerNames.set(updateIndex, IO.readln("New Customer Name: "));
            productNames.set(updateIndex, IO.readln("New Product Name: "));
            quantities.set(updateIndex, Integer.parseInt(IO.readln("New Quantity: ")));
            prices.set(updateIndex, Double.parseDouble(IO.readln("New Price: ")));
            orderStatus.set(updateIndex, IO.readln("New Status: "));
            IO.println("Order updated successfully.");
        } else IO.println("Invalid index.");

        // 8. Discount Calculation
        int discountIndex = Integer.parseInt(IO.readln("Enter Order Index for discount: "));
        double total = quantities.get(discountIndex) * prices.get(discountIndex);
        double discount = 0;
        if (total >= 5000) discount = total * 0.15;
        else if (total >= 2000) discount = total * 0.10;
        else if (total >= 1000) discount = total * 0.05;
        double finalPrice = total - discount;
        IO.println("Original: " + total + " Discount: " + discount + " Final Price: " + finalPrice);

        // 9. Remove Order
        int removeIndex = Integer.parseInt(IO.readln("Enter Order Index to remove: "));
        orderIds.remove(removeIndex);
        customerNames.remove(removeIndex);
        productNames.remove(removeIndex);
        quantities.remove(removeIndex);
        prices.remove(removeIndex);
        orderStatus.remove(removeIndex);
        IO.println("Order removed successfully. Remaining Orders: " + orderIds.size());

        // 10. Sorting Orders by Total Price

        ArrayList<Double> totalA = new ArrayList<>();
        for (int i = 0; i <= prices.size() - 1; i++) {
            Double totalP = (double) prices.get(i) * quantities.get(i);
            totalA.add(totalP);
        }
        ArrayList<Double> copyTotal = new ArrayList<>();

        ArrayList<String> copyNames = new ArrayList<>(customerNames);
        totalA.sort(null);
        copyNames.sort(null);
        for (int i = totalA.size() - 1; i >= 0; i--) {
            copyTotal.add(totalA.get(i));
        }

        IO.println("Orders sorted by total price (lowest to highest) : " + totalA);
        IO.println("Orders sorted by total price (highest to lowest) : " + copyTotal);
        IO.println("Orders sorted by customer names: " + copyNames);


    }
}

