import java.util.HashMap;
import java.util.HashSet;

    public class EmployeeSalaryManager {
    static HashSet<Integer> employeesId = new HashSet<>();
    static HashMap<Integer, Double> employeelog = new HashMap<>();
    static Integer newId;
    static Double newSalary;
    static int numbersToAdd;

    public static void main(String[] args) {
        /*prompt user to enter number of employees to add to the set*/
        numbersToAdd = Integer.parseInt(IO.readln("Enter number of employees to add: "));
        /*use if statement to check if number added is more than 0 then start a loop repeating depending on how many employees the user wants to add*/
        if (numbersToAdd <= 0) {
            IO.println("Invalid number of employees");
        } else {
            for (int i = 1; i <= numbersToAdd; i++) {
                newId = Integer.parseInt(IO.readln("Enter Employee Id: "));
                if (employeesId.contains(newId)) {                                /*check if there are duplicates*/
                    IO.println("Employee ID already exists. Record not added.");
                } else {
                    employeesId.add(newId); /*add employee Id to the set */
                    newSalary = Double.parseDouble(IO.readln("Enter Salary: ")); /*prompt user to enter salary*/
                    employeelog.put(newId, newSalary);  /*add employee id and salary to the map as key and value*/
                }
            }
        }

        int choice;
        do{
            IO.println("-----Display Menu-----");
            IO.println("1. Add Employee");
            IO.println("2. Search Employee");
            IO.println("3. Update Salary");
            IO.println("4. Remove Employee");
            IO.println("5. Display All Employess");
            IO.println("6. Display Salary Statistics");
            IO.println("7.Exit");
            choice = Integer.parseInt(IO.readln("Enter choice: "));

            switch (choice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    statistics();
                    break;
                case 7:
                    IO.println("Thank you. Goodbye");
                    break;
                default:
                    IO.println("Invalid choice. Please try again.");
                    break;


            } }while (choice != 7);
    }

       static void addEmployee(){
           Integer searchId = Integer.parseInt(IO.readln("Enter Employee ID: "));
           if(employeesId.contains(searchId)) {
               IO.println("Employee ID already exists.");
           }else{
               Double addSalary = Double.parseDouble(IO.readln("Enter Salary: "));
                   employeesId.add(searchId);
                   employeelog.put(searchId,addSalary);
                   IO.println("Employee added successfully.");
               }
           }

       static void searchEmployee(){
           Integer searchId = Integer.parseInt(IO.readln("Enter Employee ID: "));
           if(employeesId.contains(searchId)){
               IO.println("Salary: " + employeelog.get(searchId));
           }else{
               IO.println("Employee Id not found.");
           }}

        /*create method to update salary in the map*/
        static void update() {
            Integer replaceID = Integer.parseInt(IO.readln(("Enter Employee Id: ")));
            if (employeelog.containsKey(replaceID)) {
                Double updateSalary = Double.parseDouble(IO.readln(("Enter updated salary: ")));
                employeelog.replace(replaceID, updateSalary);
                IO.println("Employee salary updated successfully.");
            } else {
                IO.println("Employee ID not found.");
            }
        }

        static void removeEmployee(){
            Integer searchId = Integer.parseInt(IO.readln("Enter Employee ID: "));
            if(employeelog.containsKey(searchId)){
                employeesId.remove(searchId);
                employeelog.remove(searchId);
                IO.println("Employee removed successfully.");
            }
        }
        /*display all employees and salaries*/
        static void displayAll(){
            for(Integer key: employeelog.keySet()){
                IO.println("Employee ID: " + key + ", Salary: " + employeelog.get(key));
            }
        }

        static void statistics() {
            Double total = 0.0;
            for (Integer key : employeelog.keySet()) {
                total += employeelog.get(key);
            }
            Double average = total / employeesId.size();

            Double highest = Double.MIN_VALUE;  /*create variable for lowest and highest salaries and initialise it by max and min values*/
            Double lowest = Double.MAX_VALUE;
            Integer highestId = 0;
            Integer lowestId = 0;
            for (Integer key : employeelog.keySet()) {
                if (employeelog.get(key) > highest) {
                    highest = employeelog.get(key);
                    highestId = key;
                }
                if (employeelog.get(key) < lowest) {
                    lowest = employeelog.get(key);
                    lowestId = key;
                }
            }
            IO.println("Employee with highest salary: " + highestId + ", with a salary of: " + highest);
            IO.println("Employee with lowest salary: " + lowestId + ", with a salary of: " + lowest);
            IO.println("Total payroll: " + total);
            IO.println("Average salary: " + average);
        }



}



