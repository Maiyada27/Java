import java.io.IOError;
import java.util.ArrayList;

public class ProductInventoryManagementSystem {
     static ArrayList<String>productNames = new ArrayList<>();
     static ArrayList<Integer>productQuantities = new ArrayList<>();
     static ArrayList<Double>productPrices = new ArrayList<>();

    public static void main(String[] args){
        /*prompt user to enter product name, quantity and price and add these to corresponding lists*/
        int i = 0;
        while( i<=10 ){
            String productName = IO.readln("Enter product name: ");
            Integer quantity = Integer.parseInt(IO.readln("Enter quantity: "));
            Double price = Double.parseDouble(IO.readln("Enter price: "));
            productNames.add(productName);
            productQuantities.add(quantity);
            productPrices.add(price);
            i++;
        }
        /*use a for loop to get all products details with index numbers*/
        for(int j=0; j<= productNames.size()-1; j++) {
            IO.println("Index: " + j);
            IO.println("Product name: " + productNames.get(j));
            IO.println("Quantity: " + productQuantities.get(j));
            IO.println("Price: " + productPrices.get(j));
        }

        /*call methods*/
        addProduct();
        edit();
        search();
        analysis();
        status();
        remove();
        sort();


    }

    static void addProduct(){
        IO.println("Add new product:-");
        String productName = IO.readln("Enter product name: ");
        Integer quantity = Integer.parseInt(IO.readln("Enter quantity: "));
        Double price = Double.parseDouble(IO.readln("Enter price: "));
        productNames.add(productName);
        productQuantities.add(quantity);
        productPrices.add(price);
        IO.println("Product added successfully.");
    }

    static void edit(){
        IO.println("Edit product:-");
        Integer productIndex = Integer.parseInt(IO.readln("Enter product index: "));
        String productName = IO.readln("Enter new product name: ");
        Integer quantity = Integer.parseInt(IO.readln("Enter new quantity: "));
        Double price = Double.parseDouble(IO.readln("Enter new price: "));
        productNames.set(productIndex,productName);
        productQuantities.set(productIndex, quantity);
        productPrices.set(productIndex,price);
        IO.println("Product edited successfully.");
    }

    static void search(){
        String searchName= IO.readln("Enter product name: ");
        if(productNames.contains(searchName)){
            int searchIndex = productNames.indexOf(searchName);
            IO.println("Product name: " + searchName);
            IO.println("Quantity: " + productQuantities.get(searchIndex));
            IO.println("Price: "+ productPrices.get(searchIndex));
    }else {
            IO.println("Product not found.");
        }}

    static void analysis(){
        IO.println("Total number of products: " + productNames.size());
        Integer totalQ=0;
        for(int q: productQuantities){
        totalQ += q;
        }
        IO.println("Total quantity of products:" + totalQ);
        Double totalV=0.0;
        for(int i=0; i<= productQuantities.size()-1; i++) {
            totalV += (double) productPrices.get(i) * productQuantities.get(i);
        }
        IO.println("Total inventory value: " + totalV);
    }

    static void status() {
        ArrayList<String> lowStock = new ArrayList<>();
        ArrayList<String> outOfStock = new ArrayList<>();
        ArrayList<String> inStock = new ArrayList<>();
        for (int i = 0; i <= productQuantities.size() - 1; i++) {
            if (productQuantities.get(i) == 0) {
                outOfStock.add(productNames.get(i));
            } else if (productQuantities.get(i) > 0 && productQuantities.get(i) < 5) {
                lowStock.add(productNames.get(i));
            } else if (productQuantities.get(i) >= 5) {
                inStock.add(productNames.get(i));
            }
        }
        IO.println("Products in stock: " + inStock);
        IO.println("Low stock products: " + lowStock);
        IO.println("Out of stock products: " + outOfStock);
    }

    static void remove(){
        String searchName= IO.readln("Enter product name to remove: ");
        if(productNames.contains(searchName)){
            int searchIndex = productNames.indexOf(searchName);
            productNames.remove(searchIndex);
            productQuantities.remove(searchIndex);
            productPrices.remove(searchIndex);
        }else {
            IO.println("Product not found.");
        }}

    static void sort(){
      ArrayList<String>copyNames= new ArrayList<>(productNames);
      ArrayList<Double>copyPrices = new ArrayList<>(productPrices);
      copyNames.sort(null);
      copyPrices.sort(null);
      IO.println("Sorted product names: " + copyNames);
      IO.println("Sorted prices: " + copyPrices);
    }

    }

