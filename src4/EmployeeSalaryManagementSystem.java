import java.util.ArrayList;

public class EmployeeSalaryManagementSystem {
    static ArrayList<String> employeeNames = new ArrayList<>();
    static ArrayList<Integer> employeeIds = new ArrayList<>();
    static ArrayList<Double> employeeSalaries = new ArrayList<>();
    public static void main(String[] args){
        // Add 10 employees
        employeeIds.add(1001); employeeNames.add("Ali"); employeeSalaries.add(850.0);
        employeeIds.add(1002); employeeNames.add("Sara"); employeeSalaries.add(1200.0);
        employeeIds.add(1003); employeeNames.add("Ahmed"); employeeSalaries.add(1500.0);
        employeeIds.add(1004); employeeNames.add("Noor"); employeeSalaries.add(500.0);
        employeeIds.add(1005); employeeNames.add("Omar"); employeeSalaries.add(950.0);
        employeeIds.add(1006); employeeNames.add("Laila"); employeeSalaries.add(700.0);
        employeeIds.add(1007); employeeNames.add("Hassan"); employeeSalaries.add(400.0);
        employeeIds.add(1008); employeeNames.add("Fatima"); employeeSalaries.add(1100.0);
        employeeIds.add(1009); employeeNames.add("Khalid"); employeeSalaries.add(600.0);
        employeeIds.add(1010); employeeNames.add("Mona"); employeeSalaries.add(1300.0);

        // Display employees
                for (int i = 0; i < employeeNames.size(); i++) {
                    IO.println("Employee " + i + ": ID: " + employeeIds.get(i) +
                            " Name: " + employeeNames.get(i) +
                            " Salary: " + employeeSalaries.get(i));
                }

                // Search employee
                int searchId = Integer.parseInt(IO.readln("Enter Employee ID to search: "));
                if (employeeIds.contains(searchId)) {
                    int index = employeeIds.indexOf(searchId);
                    IO.println("Employee found at index " + index);
                    IO.println("Name: " + employeeNames.get(index));
                    IO.println("Salary: " + employeeSalaries.get(index));
                } else {
                    IO.println("Employee not found.");
                }

                // Update salary
                int updateIndex = Integer.parseInt(IO.readln("Enter Employee Index to update: "));
                double newSalary = Double.parseDouble(IO.readln("Enter New Salary: "));
                employeeSalaries.set(updateIndex, newSalary);
                IO.println("Salary updated successfully.");
                IO.println("Updated Employee: ID: " + employeeIds.get(updateIndex) +
                        " Name: " + employeeNames.get(updateIndex) +
                        " Salary: " + employeeSalaries.get(updateIndex));

                // Remove employee
                int removeIndex = Integer.parseInt(IO.readln("Enter Employee Index to remove: "));
                employeeIds.remove(removeIndex);
                employeeNames.remove(removeIndex);
                employeeSalaries.remove(removeIndex);
                IO.println("Employee removed successfully.");

                // Bonus calculation
                IO.println("Bonus Calculation:");
                for (int i = 0; i < employeeNames.size(); i++) {
                    double salary = employeeSalaries.get(i);
                    double bonus;
                    if (salary >= 1000) bonus = salary * 0.10;
                    else if (salary >= 500) bonus = salary * 0.05;
                    else bonus = salary * 0.02;

                    double finalSalary = salary + bonus;
                    IO.println("Name: " + employeeNames.get(i) +
                            " Salary: " + salary +
                            " Bonus: " + bonus +
                            " Final Salary: " + finalSalary);
                }
            }
        }


