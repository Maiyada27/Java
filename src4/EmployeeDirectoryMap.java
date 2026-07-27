import java.util.HashMap;
import java.util.Hashtable;

public class EmployeeDirectoryMap {

    static HashMap<Integer, String>employees= new HashMap<>();
    static Integer id;
    static String name;
    static int numbersToAdd=0;
    static int duplicates=0;

    public static void main(String[] args) {
        /*prompt user to enter number of cities to add to the map*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of employees to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many employees the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of employees");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                id = Integer.parseInt(IO.readln("Enter employee ID: "));
                name = IO.readln("Enter employee name: ");
                if (employees.containsKey(id)) {                                /*check if there are duplicates*/
                    IO.println("Employee ID already exists. Please enter a unique ID.");
                    duplicates += 1;
                } else {
                    employees.put(id, name);  /*add id and name to the hashmap */
                }
            }
    }
        /*call methods*/
        search();
        display();
        classify();
}
      /*create a method to search for a name in the hashmap*/
       static void search(){
           Integer searchId = Integer.parseInt(IO.readln("Enter employee ID to search for: "));
           if(employees.containsKey(searchId)) {
               IO.println("Employee Found: " + employees.get(searchId));
           }else {
               IO.println("Employee ID not found.");
           }
       }

       static void classify(){
           if(employees.size()<5) {
               IO.println("Small Company.");
           } else if (employees.size()>= 5 && employees.size()<=10) {
               IO.println("Medium Company.");
           } else if (employees.size()>10) {
               IO.println("Large Company.");
           }
       }
       /*create method to display all details about the map*/
       static void display(){
           IO.println("Total employee records entered: " + numbersToAdd);
           IO.println("Total unique employees: " + employees.size());

           for(Integer key: employees.keySet()){
               IO.println(key + " : " + employees.get(key));
           }
    }
}
