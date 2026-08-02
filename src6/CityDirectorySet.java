import java.util.TreeSet;

public class CityDirectorySet {

    static TreeSet<String> cityNames = new TreeSet<>();
    static String city;
    static int numbersToAdd=0;
    static int duplicates=0;

    public static void main(String[] args) {
        /*prompt user to enter number of cities to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of cities to add: "));

        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many cities the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of cities");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                city = (IO.readln("Enter city name: "));
                if (cityNames.contains(city)) {                                /*check if there are duplicates*/
                    IO.println("City already exists. Duplicate entries are not allowed.");
                    duplicates += 1;
                } else {
                    cityNames.add(city);  /*add city to the treeset */
                }
            }
        }
        /*call methods*/
        display();
        classify();
        search();

    }
    /*create method to search for a city*/
    static void search(){
        String searchCity = IO.readln("Enter city name: ");
        if(cityNames.contains(searchCity)) {
            IO.println("City found in the directory");
        }else {
            IO.println("City not found in the directory");
        }
    }
    /*create method to classify directory*/
    static void classify(){
        if(cityNames.size()<5) {
            IO.println("Small Directory.");
        } else if (cityNames.size()>= 5 && cityNames.size()<=10) {
            IO.println("Medium Directory.");
        } else if (cityNames.size()>10) {
            IO.println("Large Directory.");
        }
    }

    static void display(){
        IO.println("Total cities entered: " + (cityNames.size() + duplicates));
        IO.println("Total unique cities: " + cityNames.size());
        for (String c : cityNames) {
            IO.println(c);
        }
    }
}
