import java.util.ArrayList;

public class ProductInventorySystem {   /*set variable names and types*/
    static String productName;
    static Double productPrice;
    static Double productQuantity;
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Double> quantities = new ArrayList<>();
    static Double totalValue=0.00;
    static String stockStatus;
    static int availableProducts;
    static int outOfStock;
    static Double mostExpensive=0.00;





    public static void main(String[] args) {  /*create main method*/

        /*start a loop to take input for product name, price and quantity and add them to different lists*/
        for(int i=1; i<=3; i++) {
            productName = IO.readln("Enter product name:");
            products.add(productName);

            productPrice = Double.parseDouble(IO.readln("Enter product price:"));
            prices.add(productPrice);

            productQuantity = Double.parseDouble(IO.readln("Enter product quantity:"));
            quantities.add(productQuantity);
        }
           /*Call methods*/
            calculateTotalValue();
            checkStockStatus(productQuantity);
            countStockStatus();
            findMostExpensiveProduct();
            displayReport();




    }
     /*create method to calculate total value by looping through the prices list*/
    static void calculateTotalValue(){
        for(int i=0; i<= prices.size()-1; i++) {
            totalValue += prices.get(i)* quantities.get(i);
        }

    }

    /*create method to check stock status using if statement and return status*/
    static String checkStockStatus(Double productQuantity) {
        if (productQuantity > 10) {
            stockStatus = "High Stock";
        } else if (productQuantity <= 10 && productQuantity > 0) {
            stockStatus = "Available";
        } else if (productQuantity == 0) {
            stockStatus = "Out of stock";
        }
        return stockStatus;
    }

    /*start method to count stock by looping through the quantities list*/
    static void countStockStatus(){
        for (int i = 0; i <= quantities.size() - 1; i++) {
            if (quantities.get(i) > 0) {
                availableProducts += 1;
            } else {
                outOfStock += 1;
            }
        }
    }

    static void findMostExpensiveProduct() {
        for (Double price : prices) {
            if (price > mostExpensive) {
                mostExpensive = price;
            }
        }
    }

    /*create method to display report, used a loop to go through one product at a time*/
    static void displayReport(){
        for(int i=0; i<= products.size()-1; i++) {
            IO.println("Product Name: " + products.get(i));
            IO.println("Quantity: " + quantities.get(i));
            IO.println("Price: " + prices.get(i));
            IO.println("Stock status: " + checkStockStatus(quantities.get(i)));
        }
        IO.println("Most Expesive Product: "+ mostExpensive);
        IO.println("Number of available products: " + availableProducts);
        IO.println("Number of out of stock products: " + outOfStock);
        IO.println("Total inventory value: " + totalValue);

    }

}
