import java.util.HashSet;

public class ProductInventorySet {

    static HashSet<String>products= new HashSet<>();
    static String productName;
    static int duplicates=0;
    public static void main(String[] args) {

        /*prompt user to enter number of products to add to the set*/
        Integer numbersToAdd = Integer.parseInt(IO.readln("Enter number of products to add: "));

        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many products the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of products");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                productName = (IO.readln("Enter product name: "));
                if (products.contains(productName)) {                                /*check if there are duplicates*/
                    IO.println("Product already exists. Duplicate entries are not allowed.");
                    duplicates += 1;
                } else {
                    products.add(productName);  /*add product to the hashset */
                }
            }
        }
        /*call methods*/
        display();
        classify();
        search();
    }
    /*create method to search for a product in the hashset*/
    static void search(){
        String searchName = IO.readln("Enter product name: ");
        if(products.contains(searchName)) {
            IO.println("Product found in inventory");
        }else {
            IO.println("Product not found in inventory");
        }
    }
    /*create method to classify the inventory*/
    static void classify(){
        if(products.size()<5) {
            IO.println("Small Inventory.");
        } else if (products.size()>= 5 && products.size()<=10) {
            IO.println("Medium Inventory.");
        } else if (products.size()>10) {
            IO.println("Large Inventory.");
        }
    }

    /*create method to display all details*/
    static void display() {
        IO.println("Total products entered: " + (products.size() + duplicates));
        IO.println("Total unique IDs: " + products.size());
        for (String p : products) {
            IO.println(p);
        }
    }
}
