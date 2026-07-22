public class EmployeeSalaryCalculator {

    /*declare static variables in class so it can be accessed in methods*/
    static String employeeName;
    static int basicSalary;
    static int bonusAmount;
    static int deductionAmount;
    static int netSalary;
    static String status = " ";

    public static void main(String[] args) {  /*create main method inside class*/
        /*Assign values to the variables*/
        employeeName = "Lama";
        basicSalary = 700;
        bonusAmount = 300;
        deductionAmount = 150;

        /*call methods */
        calculateNetSalary();
        checkSalaryStatus();
        displaySalaryDetails();
    }

    /*create method to calculate salary*/
    static void calculateNetSalary() {
        netSalary = basicSalary + bonusAmount - deductionAmount;
    }
    /*create method to check status and use an if else statement*/
    static void checkSalaryStatus() {
        if (netSalary < 500) {
            status = "Low Salary";
        } else if (netSalary >= 500 && netSalary <= 1500) {
            status = "Medium Salary";
        } else if (netSalary > 1500) {
            status = "High Salary";
        }
    }
    /*create method to display all details */
    static void displaySalaryDetails(){
        IO.println("Employee name: " + employeeName);
        IO.println("Basic salary: " + basicSalary);
        IO.println("Bonus: " + bonusAmount);
        IO.println("Deductions: " + deductionAmount);
        IO.println("Net salary: " + netSalary);
        IO.println("Salary Status: " + status);

    }

}
