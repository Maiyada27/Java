import java.util.HashMap;

public class ProductPriceCatalog {
    static HashMap<String, Double> products = new HashMap<>();
    static int numbersToAdd = 0;
    static int duplicates = 0;

    public static void main(String[] args) {
        /*prompt user to enter number of products to add to the map*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of products to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many products the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of products");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                String product = IO.readln("Enter product name: ");
                Double price = Double.parseDouble(IO.readln("Enter price: "));
                if (products.containsKey(product)) {                                /*check if there are duplicates*/
                    IO.println("Product already exists. Record not added.");
                    duplicates += 1;
                } else {
                    products.put(product, price);  /*add product name and price to the hashmap */
                }
            }
        }
        /*call methods*/
        search();
        display();
        classify();
    }

    static void search() {
        String searchProduct = IO.readln("Enter product name: ");
        if (products.containsKey(searchProduct)) {
            String update = IO.readln("Product price: " + products.get(searchProduct) + " .Do you want to update the price for this product? (Y/N):");
            if (update.equalsIgnoreCase("Y")) {
                Double newPrice = Double.parseDouble(IO.readln("Enter new price: "));
                products.replace(searchProduct, newPrice);
                IO.println("Price updated successfully.");
            }}else {
            IO.println("Product not found.");

            }
        }

        static void classify(){
            if(products.size()<5) {
                IO.println("Small Inventory.");
            } else if (products.size()>= 5 && products.size()<=10) {
                IO.println("Medium Inventory.");
            } else if (products.size()>10) {
                IO.println("Large Inventory.");
            }
        }
        /*create method to display details about the map*/
        static void display(){
            IO.println("Total products entered: " + numbersToAdd);
            IO.println("Total unique products: " + products.size());

            for(String key: products.keySet()){
                IO.println(key + " : " + products.get(key));
            }
        }
}
